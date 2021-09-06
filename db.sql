-- First, create the db and connect to it
DROP TABLE IF EXISTS "sentence";
CREATE TABLE "public"."sentence" (
    "id" bigint NOT NULL,
    "sentence" character varying(255),
    "translation" character varying(255),
    CONSTRAINT "sentence_pkey" PRIMARY KEY ("id")
) WITH (oids = false);

DROP TABLE IF EXISTS "user_data";
CREATE TABLE "public"."user_data" (
    "id" bigint NOT NULL,
    "account_creation" date,
    "amount_points" integer NOT NULL,
    "password" character varying(255),
    "username" character varying(255),
    CONSTRAINT "user_data_pkey" PRIMARY KEY ("id")
) WITH (oids = false);
