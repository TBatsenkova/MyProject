Feature: Авторизация через телефон с неверным кодом

  Background:
    Given Пользователь находится на главной странице

    Scenario:
      When







      entryAndRegistrationButton.click();
    enterByPhoneNumber.click();
    inputPhoneNumber.sendKeys(randomPhoneNumber(), Keys.ENTER);