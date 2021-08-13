BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Plant" (
	"plant_id"	INTEGER,
	"plant_name"	TEXT,
	"plant_image"	INTEGER,
	"plant_type_name"	TEXT,
	"plant_type_water"	TEXT,
	"plant_type_details"	TEXT,
	PRIMARY KEY("plant_id")
);
INSERT INTO "Plant" ("plant_id","plant_name","plant_image","plant_type_name","plant_type_water","plant_type_details") VALUES (1,'Aloe',1,'Aloe','1 per week','Dangerous to pets');
COMMIT;
