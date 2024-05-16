CREATE TABLE "clinics" (
  "id" int,
  "name" varchar,
  "cellphone" varchar,
  "address" varchar
);

CREATE TABLE "pets" (
  "id" int PRIMARY KEY,
  "id_owner" bigint,
  "name" varchar,
  "breedId" int,
  "gender" varchar,
  "age" smallint,
  "size" varchar,
  "weight" integer
);

CREATE TABLE "breends" (
  "id" int PRIMARY KEY,
  "name" varchar,
  "categoryId" int
);

CREATE TABLE "categories" (
  "id" int PRIMARY KEY,
  "name" varchar
);

CREATE TABLE "users" (
  "id" int PRIMARY KEY,
  "clinic_id" bigint,
  "name" varchar,
  "birth_date" varchar,
  "gender" varchar,
  "cellphone" varchar,
  "document" varchar,
  "address" varchar,
  "speciality" varchar,
  "active" boolean,
  "email" varchar,
  "password" varchar,
  "type" smallint
);

CREATE TABLE "pet_owners" (
  "id" int PRIMARY KEY,
  "pet_id" bigint,
  "name" varchar,
  "document" varchar,
  "birth_date" varchar,
  "gender" varchar,
  "cellphone" varchar,
  "address" varchar,
  "cep" varchar,
  "neighborhood" varchar,
  "city" varchar
);

CREATE TABLE "schedules" (
  "id" int PRIMARY KEY,
  "clinic_id" bigint,
  "user_id" bigint,
  "date_start" varchar,
  "date_finish" varchar,
  "hour_start" varchar,
  "hour_end" varchar,
  "horary" varchar,
  "duration" smallint
);

CREATE TABLE "appointments" (
  "id" int PRIMARY KEY,
  "schedule_id" bigint,
  "user_id" bigint,
  "pet_id" bigint,
  "procedure" varchar,
  "hour" varchar,
  "status" varchar,
  "isException" boolean
);

CREATE TABLE "enchiridion" (
  "id" int PRIMARY KEY,
  "pet_id" bigint,
  "anamnese" varchar,
  "prescription" varchar
);

CREATE TABLE "medicine_stock" (
  "id" int PRIMARY KEY,
  "name" varchar,
  "miligrams" varchar,
  "quantity" integer
);

CREATE TABLE "users_clinics" (
  "users_clinic_id" bigint,
  "clinics_id" int,
  PRIMARY KEY ("users_clinic_id", "clinics_id")
);

ALTER TABLE "users_clinics" ADD FOREIGN KEY ("users_clinic_id") REFERENCES "users" ("clinic_id");

ALTER TABLE "users_clinics" ADD FOREIGN KEY ("clinics_id") REFERENCES "clinics" ("id");


ALTER TABLE "pets" ADD FOREIGN KEY ("id") REFERENCES "pet_owners" ("pet_id");

ALTER TABLE "schedules" ADD FOREIGN KEY ("clinic_id") REFERENCES "clinics" ("id");

ALTER TABLE "users" ADD FOREIGN KEY ("id") REFERENCES "schedules" ("user_id");

ALTER TABLE "appointments" ADD FOREIGN KEY ("pet_id") REFERENCES "pets" ("id");

ALTER TABLE "appointments" ADD FOREIGN KEY ("schedule_id") REFERENCES "schedules" ("id");

ALTER TABLE "appointments" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "pets" ADD FOREIGN KEY ("id") REFERENCES "enchiridion" ("pet_id");

ALTER TABLE "pets" ADD FOREIGN KEY ("breedId") REFERENCES "breends" ("id");

ALTER TABLE "breends" ADD FOREIGN KEY ("categoryId") REFERENCES "categories" ("id");

ALTER TABLE "users" ADD FOREIGN KEY ("cellphone") REFERENCES "users" ("birth_date");

ALTER TABLE "schedules" ADD FOREIGN KEY ("user_id") REFERENCES "schedules" ("date_start");

ALTER TABLE "pet_owners" ADD FOREIGN KEY ("name") REFERENCES "appointments" ("pet_id");
