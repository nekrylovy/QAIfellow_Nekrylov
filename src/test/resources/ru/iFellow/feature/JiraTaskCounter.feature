# language: ru
@jira
Функция: Проверка увеличения счетчика задач
  Предыстория:
    Дано логин AT7 и пароль Qwerty123
    Тогда проверить имя пользователя в профиле
    Дано перейти в проект Test
    Тогда проверить название проекта
  Сценарий: Проверка счетчика задач
    Дано создать новую задачу
    Тогда проверить счетчик задач