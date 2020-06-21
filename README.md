## Random Word Object API

### Database Setting
#### Dockerilized Postgresql Database
bash
```
$ docker-compose up -d
$ docker exec -it random-word-api bash
root#<container ID>: psql -U posrgres;
postgres=#: CREATE DATABASE word_db;
```