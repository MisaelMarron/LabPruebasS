from check_connection import SeleniumConnection
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException
import time, json
from utils import Utils

class TestFn17:
    def __init__(self, driver, url):
        self.driver, self.url, self.path = driver, url, "/web/instructor/courses/enroll?courseid=mmarronl.uns-demo"
        self.button_id = "btn-enroll"
        self.table_id = "newStudentsHOT"

        # Orden de columnas: Section, Team, Name, Email, Comments
        self.columns = ["Section", "Team", "Name", "Email", "Comments"]

        with open("data/fn17.json") as f:
            self.cases = json.load(f)

    def go_to_form(self):
        self.driver.get(self.url + self.path)
        WebDriverWait(self.driver, 10).until(
            EC.presence_of_element_located((By.ID, self.button_id))
        )

    def fill_table(self, fields):
        try:
            # Esperamos a que aparezca la tabla editable
            WebDriverWait(self.driver, 10).until(
                EC.presence_of_element_located((By.ID, self.table_id))
            )

            table_xpath = f"//div[@id='{self.table_id}']//table"
            row_xpath = table_xpath + "//tbody/tr[last()]"
            
            # Llenamos la última fila
            for i, col in enumerate(self.columns):
                value = fields.get(col, "")
                if value != "":
                    input_xpath = f"{row_xpath}/td[{i+1}]//input"
                    cell_input = WebDriverWait(self.driver, 5).until(
                        EC.presence_of_element_located((By.XPATH, input_xpath))
                    )
                    cell_input.clear()
                    cell_input.send_keys(value)
        except Exception as e:
            print(f"Error llenando tabla: {e}")

    def submit(self):
        self.driver.find_element(By.ID, self.button_id).click()
        time.sleep(2)

    def get_message(self):
        try:
            msg_element = WebDriverWait(self.driver, 5).until(
                EC.presence_of_element_located((By.XPATH, "//div[contains(@class,'alert') or contains(@class,'message') or contains(text(),'Enrollment') or contains(text(),'Found empty') or contains(text(),'failed')]"))
            )
            return msg_element.text.strip()
        except TimeoutException:
            return "[NO MESSAGE FOUND]"

    def run_case(self, case):
        self.go_to_form()
        self.fill_table(case["fields"])
        self.submit()

        obtained = self.get_message()

        Utils.log_test(
            case["id"],
            case["fields"],
            case["expected"],
            obtained,
            case["Obs"]
        )
        return {
            "id": case["id"],
            "expected": case["expected"],
            "obtained": obtained
        }

    def run(self):
        print("******************** RUN TEST-FN17 IN ********************")
        for case in self.cases:
            self.run_case(case)
        print("******************** **************** ********************")
        print("")

if __name__ == "__main__":
    checker = SeleniumConnection()
    driver, url = checker.connect_and_check_login()
    TestFn17(driver, url).run()