### Проект разработал Садовский А.Д. https://t.me/aleks_wb_spb

Я не закончил с поиском по части имени. Немогу изменить 
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