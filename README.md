### Проект разработал Садовский А.Д. https://t.me/aleks_wb_spb
Незаконченный проект

### ЗАДАНИЕ:
Спроектировать и разработать систему регистрации и обработки пользовательских заявок. Пользователь посредством системы может подавать заявки оператору на рассмотрение. Оператор может просматривать пользовательские заявки и принимать или отклонять их. Администратор управляет правами доступа.
    • Спроектировать и разработать back-приложение
    • Спроектировать и разработать Базу данных

Функции приложения
    • Создать заявку (Заявка помимо прочих системных полей состоит из статуса и текстового обращения пользователя)
    • Отправить заявку оператору на рассмотрение
    • Просмотреть список заявок с возможностью сортировки по дате создания в оба направления (как от самой старой к самой новой, так и наоборот) и пагинацией по 5 элементов
    • Посмотреть заявку
    • Принять заявку
    • Отклонить заявку
    • Просмотреть список пользователей
    • Назначить права оператора

В системе предусмотрены 3 роли:
    • Пользователь
    • Оператор
    • Администратор

У пользователя системы может быть одновременно несколько ролей, например, «Оператор» и «Администратор». 
У заявки пользователя предусмотрено 4 состояния:
    • черновик
    • отправлено
    • принято
    • отклонено

Пользователь может 
    • создавать заявки
    • просматривать созданные им заявки с возможностью сортировки по дате создания в оба направления (как от самой старой к самой новой, так и наоборот) и пагинацией по 5 элементов
    • редактировать созданные им заявки в статусе «черновик»
    • отправлять заявки на рассмотрение оператору.
Пользователь НЕ может:
    • редактировать отправленные на рассмотрение заявки
    • видеть заявки других пользователей
    • принимать заявки
    • отклонять заявки
    • назначать права
    • смотреть список пользователей

Оператор может
    • Просматривать все отправленные на рассмотрение  заявки с возможностью сортировки по дате создания в оба направления (как от самой старой к самой новой, так и наоборот) и пагинацией по 5 элементов
    • Просматривать отправленные заявки только конкретного пользователя по его имени/части имени (у пользователя, соотетственно, должно быть поле name) с возможностью сортировки по дате создания в оба направления (как от самой старой к самой новой, так и наоборот) и пагинацией по 5 элементов
    • Принимать заявки
    • Отклонять заявки
Оператор НЕ может
    • создавать заявки
    • просматривать заявки в статусе отличном от «отправлено»
    • редактировать заявки
    • назначать права

Администратор может
    • смотреть список пользователей
    • искать конкретного пользователя по его имени/части имени
    • назначать пользователям права оператора
Администратор НЕ может
    • создавать заявки
    • просматривать заявки
    • редактировать заявки 
    • принимать заявки
    • отклонять заявки


Технические требования к приложению
    • Java 1.8/Java 11
    • Использовать архитектуру REST
    • Использовать Spring Boot
    • Использовать Spring Security
    • Использовать Hibernate
    • Использовать реляционную БД (MS SQL, MS SQL Lite, PostgreSQL, MariaBD)
    • Создание пользователей и ролей не предусмотрено в этой системе. Подразумевается, что данные об учетных записях пользователей и роли уже есть в БД.
    • В случае просмотра заявки оператором текст заявки выводить со знаком <-> после каждого символа. Пример: Пользователь отправил на рассмотрение заявку с текстом «Мне нужна помощь», а оператор на экране видит текст в формате «М-н-е- -н-у-ж-н-а- -п-о-м-о-щ-ь».



PostRepository для того, что бы брать из базы отфильтрованные значения. 

@Query("SELECT * FROM post WHERE user_name LIKE '%keyword%'")
List<Post> findByNameStartingWith(String name);

Выдает ошибку:
rg.springframework.beans.factory.BeanCreationException: Error creating bean with name 'postRepository2' defined in com.example.goodJobAleks.repositories.PostRepository2 defined in @EnableJpaRepositories declared on JpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration: Could not create query for public abstract java.util.List com.example.goodJobAleks.repositories.PostRepository2.findByNameStartingWith(java.lang.String); Reason: Validation failed for query for method public abstract java.util.List com.example.goodJobAleks.repositories.PostRepository2.findByNameStartingWith(java.lang.String)
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1770) ~[spring-beans-6.0.7.jar:6.0.7]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:598) ~[spring-beans-6.0.7.jar:6.0.7]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:520) ~[spring-beans-6.0.7.jar:6.0.7]
at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:326) ~[spring-beans-6.0.7.jar:6.0.7]
at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.0.7.jar:6.0.7]
at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:324) ~[spring-beans-6.0.7.jar:6.0.7]
at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200) ~[spring-beans-6.0.7.jar:6.0.7]
at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:967) ~[spring-beans-6.0.7.jar:6.0.7]
at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:917) ~[spring-context-6.0.7.jar:6.0.7]
at org.springframework.cont
решения пока не нашел.
