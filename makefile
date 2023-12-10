run-all:
	docker compose down; docker compose build; docker compose up;

app:
	docker compose build app; docker compose up app;

database:
	docker compose build postgres; docker compose up postgres;

stop:
	docker compose down;
