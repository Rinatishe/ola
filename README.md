# SOLVA OLA PROJECT
Прототип микросервиса, без разграничения доступа к API,для интегрирования в банковскую систему

## Перед запуском необходим postgreSQL 
Username: postgres<br/>
Password: developer

#### Сущности описаны в entities_sql.svg

## swagger по пути http://localhost:8080/swagger-ui/index.html#/
Описывает 2 REST API
1. Для приема транзакций http://localhost:8080/operation/create
2. Для внешних запросов от клиента 
    1. http://localhost:8080/limit/save
    1. http://localhost:8080/operation/getAllExceeded
    
   
### Актуальный курс USD/KZT пары на момент закрытия запрашиваются и сохраняются каждлые 24 часа в БД
Информация запращивается у ресурса https://www.alphavantage.co

