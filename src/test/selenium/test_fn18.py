from check_connection import SeleniumConnection
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException
import time, json
from utils import Utils

class TestFn18:
    def __init__(self, driver, url):
        self.driver, self.url, self.path = driver, url, "/web/instructor/courses/student/edit?courseid=CS123&studentemail=jean@example.com"
        self.form_fields = {
            "Name": (By.ID, "student-name"),
            "Section": (By.ID, "section-name"),
            "Team": (By.ID, "team-name"),
            "Email": (By.ID, "new-student-email"),
            "Comments": (By.ID, "comments")
        }
        self.form_id = "instructor-student-edit-form"
        self.submit_button_id = "btn-submit"

        with open("data/fn18.json") as f:
            self.cases = json.load(f)

    def go_to_form(self):
        self.driver.get(self.url + self.path)
        WebDriverWait(self.driver, 10).until(
            EC.presence_of_element_located((By.ID, self.form_id))
        )

    def fill_form(self, fields):
        for key, value in fields.items():
            if key in self.form_fields:
                try:
                    el = WebDriverWait(self.driver, 5).until(
                        EC.presence_of_element_located(self.form_fields[key])
                    )
                    el.clear()
                    el.send_keys(value)
                except Exception as e:
                    print(f"Error llenando campo {key}: {e}")

    def submit(self):
        self.driver.find_element(By.ID, self.submit_button_id).click()
        time.sleep(2)

    def element_exists(self, xpath):
        try:
            WebDriverWait(self.driver, 5).until(
                EC.presence_of_element_located((By.XPATH, xpath))
            )
            return True
        except TimeoutException:
            return False

    def run_case(self, case):
        self.go_to_form()
        self.fill_form(case.get("fields", {}))
        self.submit()

        found = self.element_exists(case["element_locator"])
        obtained = "Elemento encontrado" if found else "Elemento no encontrado"

        Utils.log_test(
            case["id"],
            case.get("fields", {}),
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
        print("******************** RUN TEST-FN18 IN ********************")
        for case in self.cases:
            self.run_case(case)
        print("******************** **************** ********************")
        print("")

if __name__ == "__main__":
    checker = SeleniumConnection()
    driver, url = checker.connect_and_check_login()
    TestFn18(driver, url).run()
