from selenium import webdriver
import time

driver = webdriver.Chrome()
driver.get("http://localhost:8080/musicPlayer/login.html")
driver.maximize_window()
driver.find_element_by_id()
if __name__ == "__main__":
