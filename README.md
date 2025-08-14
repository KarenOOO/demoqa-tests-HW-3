
<a href="https://bivgroup.ru/ "> <img src="media/logo/demoqaLogo.png" width="200" height="200"> 
<h1 >Проект по автоматизации тестирования для компании <a href="https://demoqa.com/ "> DEMOQA </a></h1> 

## ☑️ Содержание:

- [Технологический стек](#-технологический-стек)
- [Web-тесты](#-web-тесты)
- [Запуск тестов в Jenkins](#-запуск-тестов-в-jenkins)
- [Allure-отчет](#-allure-отчет)
- [Уведомления в Telegram](#-уведомления-в-telegram)
- [Видео с запуском тестов в Selenoid](#-видео-с-запуском-тестов-в-selenoid)


<a id="tools"></a>
## 💻 Технологии и инструменты:

<div align="center">
  <table>
    <tr>
      <!-- Первая строка -->
      <td align="center" width="110">
        <a href="https://www.jetbrains.com/idea/" target="_blank">
          <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" width="48" height="48" alt="IntelliJ IDEA" />
        </a>
        <br>IDEA
      </td>
      <td align="center" width="110">
        <a href="https://www.java.com" target="_blank">
          <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="48" height="48" alt="Java" />
        </a>
        <br>Java
      </td>
      <td align="center" width="110">
        <a href="https://junit.org/junit5/" target="_blank">
          <img src="https://junit.org/junit5/assets/img/junit5-logo.png" width="48" height="48" alt="JUnit 5" />
        </a>
        <br>JUnit 5
      </td>
      <td align="center" width="110">
        <a href="https://gradle.org/" target="_blank">
          <img src="https://cdn.simpleicons.org/gradle/02303A" width="48" height="48" alt="Gradle" />
        </a>
        <br>Gradle
      </td>
    </tr>
    <tr>
      <!-- Вторая строка -->
      <td align="center" width="110">
        <a href="https://docs.qameta.io/allure/" target="_blank">
          <img src="https://avatars.githubusercontent.com/u/5879127?s=200&v=4" width="48" height="48" alt="Allure" />
        </a>
        <br>Allure
      </td>
      <td align="center" width="110">
        <a href="https://www.jenkins.io/" target="_blank">
          <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/jenkins/jenkins-original.svg" width="48" height="48" alt="Jenkins" />
        </a>
        <br>Jenkins
      </td>
      <td align="center" width="110">
        <a href="https://github.com/" target="_blank">
          <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original.svg" width="48" height="48" alt="GitHub" />
        </a>
        <br>GitHub
      </td>
      <td align="center" width="110">
        <a href="https://rest-assured.io/" target="_blank">
          <img src="https://rest-assured.io/img/logo-transparent.png" width="48" height="48" alt="Rest-Assured" />
        </a>
        <br>Rest-Assured
      </td>
    </tr>
  </table>
</div>

- Тесты написаны на **Java** с использованием фреймворка **Selenide** в **IntelliJ IDEA**
- Сборка проекта осуществляется через **Gradle**
- Запуск тестов в контейнерах **Selenoid**
- Интеграция с **Jenkins** + автоматическая отправка отчетов в **Telegram**

## 🌐 Web-тесты

### Реализованные проверки:

-  ✅ Открываем форму регистрации студента
-  ✅ Проверяем заголовок страницы
-  ✅ Заполняем все поля и отправляем анкету
-  ✅ Проверяем все переданные данные
-  ✅ Проверяем завершение заполнения анкеты с заполнением только обязательных полей
-  ✅ Проверяем переданные данные
-  ✅ Проверяем возможность отправить анкету не заполняя поля
-  ✅ Проверяем валидацию полей

## [<img src="media/logo/Jenkins.svg" width="40" height="40" alt="Jenkins"> Запуск тестов в Jenkins](https://jenkins.autotests.cloud/job/UI-tests-Diplom/) 


<p align="center">  
<img src="media/reports/jenkinsNew.png" alt="Jenkins" width="950"/></>  
</p>


### ☑️ Параметры сборки в Jenkins:

- browser (браузер, по умолчанию chrome)
- browserVersion (версия браузера, по умолчанию 127.0)
- browserSize (размер окна браузера, по умолчанию 1920x1080)


### Команда для запуска из терминала
Локальный запуск
```bash
gradle clean regress_test 
```
```bash  
clean 
${TASK}
-Dbrowser="${BROWSER}"
-DbrowserSize="${BROWSER_SIZE}"
-DbrowserVersion="${BROWSER_VERSION}"
-DbrowserRemote="https://log:pass@${BROWSER_REMOTE}/wd/hub"
```

## [<img src="media/logo/Allure.svg" width="40" height="40" alt="Allure"> Allure-отчет](https://jenkins.autotests.cloud/job/UI-tests-Diplom/4/allure/)


### ☑️ Главная страница Allure-отчета

<p align="center">  
<img title="Allure Overview Dashboard" src="media/reports/allurReport1.png" width="850">  
</p> 
<p align="center">  
<img title="Allure Overview Dashboard" src="media/reports/allurReport2.png" width="850">  
</p>
<p align="center">  
<img title="Allure Overview Dashboard" src="media/reports/allurReport3.png" width="850">  
</p>
<p align="center">  
<img title="Allure Overview Dashboard" src="media/reports/allurReport4.png" width="850">  
</p>
### ☑️ График
<p align="center">  
<img title="Allure Overview Dashboard" src="media/reports/graphicsNew.png" width="850">  
</p>

____
### <img src="media/logo/Telegram.svg" width="40" height="40" alt="Allure"> Allure Уведомление в Telegram при помощи бота
____
<p align="center">  
<img title="Allure Overview Dashboard" src="media/reports/telegramNew.png" width="850">  
</p>

### После завершения сборки, бот, созданный в Telegram, автоматически обрабатывает и отправляет сообщение с результатом

____