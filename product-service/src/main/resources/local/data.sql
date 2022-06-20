--cleaning structure
DROP TABLE IF EXISTS medical_service;
DROP SEQUENCE IF EXISTS sq_medical_service_id;
DROP TABLE IF EXISTS ward_descr;
DROP SEQUENCE IF EXISTS sq_ward_descr_id;
DROP TABLE IF EXISTS health_descr;
DROP SEQUENCE IF EXISTS sq_health_descr_id;
DROP TABLE IF EXISTS doctor;
DROP SEQUENCE IF EXISTS sq_doctor_id;
DROP TABLE IF EXISTS health;
DROP SEQUENCE IF EXISTS sq_health_id;
DROP TABLE IF EXISTS ward;
DROP SEQUENCE IF EXISTS sq_ward_id;
DROP TABLE IF EXISTS reservation;
DROP SEQUENCE IF EXISTS sq_reservation_id;
DROP TABLE IF EXISTS proposal;
DROP SEQUENCE IF EXISTS sq_proposal_id;

-- reimport data
CREATE TABLE IF NOT EXISTS ward (
    id INT PRIMARY KEY,
    ward_code VARCHAR(50) NOT NULL,
    insert_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    enabled BOOLEAN NOT NULL DEFAULT TRUE
);
CREATE SEQUENCE IF NOT EXISTS sq_ward_id;
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0001');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0002');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0003');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0004');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0005');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0006');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0007');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0008');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0009');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0010');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0011');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0012');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0013');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0014');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0015');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0016');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0017');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0018');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0019');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0020');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0021');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0022');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0023');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0024');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0025');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0026');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0027');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0028');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0029');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0030');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0031');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0032');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0033');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0034');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0035');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0036');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0037');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0038');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0039');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0040');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0041');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0042');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0043');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0044');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0045');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0046');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0047');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0048');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0049');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0050');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0051');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0052');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0053');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0054');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0055');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0056');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0057');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0058');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0059');
INSERT INTO ward (id, ward_code) VALUES (sq_ward_id.nextval, 'OH-0060');




CREATE TABLE IF NOT EXISTS ward_descr (
    id INT PRIMARY KEY,
    ward_code VARCHAR(50) NOT NULL,
    lang VARCHAR(2) NOT NULL,
    description VARCHAR(100) NOT NULL,
    info VARCHAR(100),
    insert_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ward_code) REFERENCES ward(ward_code)
);
CREATE SEQUENCE IF NOT EXISTS sq_ward_descr_id;
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0001', 'it', 'Allergologia');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0001', 'en', 'Allergology');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0002', 'it', 'Anatomia Patologica');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0002', 'en', 'Pathological anatomy');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0003', 'it', 'Anestesia E Rianimazione');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0003', 'en', 'Anesthesia and resuscitation');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0004', 'it', 'Anestesia E Rianimazione In Urgenza');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0004', 'en', 'Anesthesia And Resuscitation In Urgency');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0005', 'it', 'Blocco Operatorio');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0005', 'en', 'Surgical unit');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0006', 'it', 'Cardiologia E Scompenso Cardiaco');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0006', 'en', 'Cardiology and heart failure');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0007', 'it', 'Cardiologia E Utic');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0007', 'en', 'Cardiology And Utic');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0008', 'it', 'Centrale Di Sterilizzazione');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0008', 'en', 'Central sterilization');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0009', 'it', 'Centro Di Medicina Della Riproduzione E Tecniche Di Fecondazione Assistita');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0009', 'en', 'Center for Reproductive Medicine and Assisted Reproduction Techniques');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0010', 'it', 'Chirurgia Generale');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0010', 'en', 'General surgery');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0011', 'it', 'Chirurgia Vascolare');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0011', 'en', 'Vascular surgery');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0012', 'it', 'Day Surgery E Chirurgia Ambulatoriale');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0012', 'en', 'Day Surgery And Outpatient Surgery');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0013', 'it', 'Dermatologia');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0013', 'en', 'Dermatology');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0014', 'it', 'Diagnostica Ad Alta Complessità');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0014', 'en', 'High Complexity Diagnostics');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0015', 'it', 'Diagnostica Per Immagini / Radiologia');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0015', 'en', 'Diagnostic Imaging / Radiology');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0016', 'it', 'Dietologia');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0016', 'en', 'Dietetics');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0017', 'it', 'Dimissioni Ospedaliere Protette');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0017', 'en', 'Protected hospital discharge');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0018', 'it', 'Direzione Medica Dei Presidi');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0018', 'en', 'Medical Direction of Headmasters');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0019', 'it', 'Direzione Medica: Qualità, Accreditamento E Formazione');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0019', 'en', 'Medical Management: Quality, Accreditation And Training');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0020', 'it', 'Ematologia E Centro Trapianti');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0020', 'en', 'Hematology And Transplant Center');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0021', 'it', 'Emodinamica E Cardiologia Interventistica');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0021', 'en', 'Hemodynamics and Interventional Cardiology');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0022', 'it', 'Endocrinologia E Diabetologia');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0022', 'en', 'Endocrinology and Diabetology');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0023', 'it', 'Farmacia Interna');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0023', 'en', 'Internal Pharmacy');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0024', 'it', 'Fisica Medica Ed Alte Tecnologie');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0024', 'en', 'Medical Physics And High Technologies');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0025', 'it', 'Gastroenterologia Ed Endoscopia Digestiva');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0025', 'en', 'Gastroenterology And Digestive Endoscopy');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0026', 'it', 'Geriatria');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0026', 'en', 'Geriatrics');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0027', 'it', 'Gestione Rischio Clinico E Sicurezza Dei Dipendenti');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0027', 'en', 'Clinical Risk Management And Employee Safety');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0028', 'it', 'Immunoematologia E Trasfusionale');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0028', 'en', 'Immunohematology and Transfusion');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0029', 'it', 'Laboratorio Analisi');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0029', 'en', 'Analysis laboratory');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0030', 'it', 'Malattie Infettive');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0030', 'en', 'Infectious diseases');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0031', 'it', 'Medicina Di urgenza');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0031', 'en', 'Emergency Medicine');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0032', 'it', 'Medicina Interna');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0032', 'en', 'Internal Medicine');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0033', 'it', 'Medicina Nucleare');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0033', 'en', 'Nuclear medicine');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0034', 'it', 'Nefrologia E Dialisi');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0034', 'en', 'Nephrology And Dialysis');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0035', 'it', 'Neurochirurgia');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0035', 'en', 'Neurosurgery');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0036', 'it', 'Neurologia');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0036', 'en', 'Neurology');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0037', 'it', 'Neuropsichiatria Infantile');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0037', 'en', 'Child Neuropsychiatry');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0038', 'it', 'Nutrizione Artificiale Ospedaliera');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0038', 'en', 'Artificial Nutrition Hospital');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0039', 'it', 'Oculistica');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0039', 'en', 'Ophthalmology');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0040', 'it', 'Odontostomatologia');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0040', 'en', 'Odontostomatology');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0041', 'it', 'Oncologia');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0041', 'en', 'Oncology');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0042', 'it', 'Ortopedia E Traumatologia');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0042', 'en', 'Orthopedics and traumatology');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0043', 'it', 'Ostetricia E Ginecologia');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0043', 'en', 'Obstetrics and Gynecology');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0044', 'it', 'Otorinolaringoiatria');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0044', 'en', 'Otolaryngology');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0045', 'it', 'Pediatria');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0045', 'en', 'Pediatrics');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0046', 'it', 'Pneumologia');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0046', 'en', 'Pulmonology');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0047', 'it', 'Poliambulatorio');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0047', 'en', 'Outpatient clinic');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0048', 'it', 'Polo Endoscopico');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0048', 'en', 'Endoscopic pole');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0049', 'it', 'Post Acuzie');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0049', 'en', 'Post Acuzie');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0050', 'it', 'Professioni Sanitarie Iotr');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0050', 'en', 'Health Professions Iotr');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0051', 'it', 'Pronto Soccorso');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0051', 'en', 'Emergency room');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0052', 'it', 'Psicologia Ospedaliera');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0052', 'en', 'Hospital Psychology');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0053', 'it', 'Radiologia Interventistica E Neuroradiologia');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0053', 'en', 'Interventional Radiology and Neuroradiology');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0054', 'it', 'Radioterapia');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0054', 'en', 'Radiotherapy');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0055', 'it', 'Riabilitazione');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0055', 'en', 'Rehabilitation');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0056', 'it', 'Senologia / Breast Unit');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0056', 'en', 'Senology / Senology');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0057', 'it', 'Servizio Di Igiene Ospedaliera');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0057', 'en', 'Hospital Hygiene Service');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0058', 'it', 'Sicurezza Dei Pazienti E Medicina Competente');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0058', 'en', 'Patient Safety And Competent Medicine');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0059', 'it', 'Stroke Unit');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0059', 'en', 'Stroke Unit');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0060', 'it', 'Urologia');
INSERT INTO ward_descr (id, ward_code, lang, description) VALUES (sq_ward_descr_id.nextval, 'OH-0060', 'en', 'Urology');



CREATE TABLE IF NOT EXISTS health (
    id INT PRIMARY KEY,
    ward_code VARCHAR(50) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    insert_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (ward_code) REFERENCES ward(ward_code)
);
CREATE SEQUENCE IF NOT EXISTS sq_health_id;
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0001', 4122);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0002', 1569);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0003', 797);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0004', 3818);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0005', 2710);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0006', 571);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0007', 4388);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0008', 1626);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0009', 3885);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0010', 4023);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0010', 2717);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0010', 3238);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0010', 3825);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0010', 1446);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0010', 3310);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0010', 565);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0010', 4023);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0010', 4037);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0010', 3021);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0011', 4037);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0011', 1102);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0011', 2461);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0011', 2827);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0011', 1461);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0011', 1531);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0011', 513);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0011', 5047);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0011', 4965);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0012', 2281);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0013', 1937);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0014', 4333);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0015', 3439);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0016', 1734);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0017', 3050);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0018', 3117);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0019', 2717);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0020', 3238);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0021', 3825);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0022', 1446);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0023', 3310);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0024', 565);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0025', 4023);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0026', 4037);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0027', 1102);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0028', 2461);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0029', 2827);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0030', 1461);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0031', 1531);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0032', 513);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0033', 2693);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0034', 2293);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0035', 3861);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0036', 2567);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0037', 121);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0038', 1516);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0039', 1221);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0040', 4978);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0041', 1881);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0042', 3021);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0043', 3791);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0044', 3691);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0045', 3411);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0046', 3068);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0047', 1333);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0048', 1265);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0049', 2785);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0050', 3943);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0051', 2012);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0052', 4117);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0053', 223);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0054', 4440);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0055', 3949);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0056', 4364);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0057', 211);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0058', 3235);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0059', 2061);
INSERT INTO health (id, ward_code, price) VALUES (sq_health_id.nextval, 'OH-0060', 398);


CREATE TABLE IF NOT EXISTS health_descr (
    id INT PRIMARY KEY,
    health_id INT NOT NULL,
    lang VARCHAR(2) NOT NULL,
    description VARCHAR(100) NOT NULL,
    info VARCHAR(100),
    insert_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (health_id) REFERENCES health(id)
);
CREATE SEQUENCE IF NOT EXISTS sq_health_descr_id;
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 1, 'it', 'Colecistectomia laparotomica');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 1, 'en', 'Laparotomic cholecystectomy');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 2, 'it', 'Calcolosi della via biliare');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 2, 'en', 'Calculosis of the biliary tract');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 3, 'it', 'Colecistectomia laparotomica');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 10, 'it', 'Chirurgia laparoscopica per reflusso gastroesofageo');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 10, 'en', 'Laparoscopic surgery for gastroesophageal reflux');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 11, 'it', 'Chirurgia dello stomaco in elezione ed urgenza');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 11, 'en', 'Stomach surgery in election and urgency');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 12, 'it', 'Chirurgia videolaparoscopica dello stomaco in elezione ed urgenza');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 12, 'en', 'Elective and urgent videolaparoscopic stomach surgery');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 13, 'it', 'Gastrostomia chirurgica');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 13, 'en', 'Surgical gastrostomy');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 14, 'it', 'Ileostomia');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 14, 'en', 'Ileostomy');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 15, 'it', 'Chiusura ileostomia');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 15, 'en', 'Ileostomy closure');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 16, 'it', 'Colostomia');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 16, 'en', 'Colostomy');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 17, 'it', 'Idrocele');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 17, 'en', 'Hydrocele');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 18, 'it', 'Varicocele');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 18, 'en', 'Varicocele');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 20, 'it', 'Chirurgia delle varici');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 20, 'en', 'Varicose vein surgery');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 21, 'it', 'Safenectomia');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 21, 'en', 'Safenectomy');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 22, 'it', 'Flebectomie');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 22, 'en', 'Phlebectomy');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 23, 'it', 'CHIVA');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 23, 'en', 'CHIVA');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 24, 'it', 'Confezionamento Fistole Artero-Venose');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 24, 'en', 'Artero-venous fistulae packaging');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 25, 'it', 'Posizionamento di accessi vascolari impiantabili');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 25, 'en', 'Placement of implantable vascular accesses');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 26, 'it', 'Embolectomie');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 26, 'en', 'Embolectomy');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 27, 'it', 'Amputazioni');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 27, 'en', 'Amputations');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 28, 'it', 'Chirurgia vascolare in emergenza/urgenza');
INSERT INTO health_descr (id, health_id, lang, description) VALUES (sq_health_descr_id.nextval, 28, 'en', 'Emergency / urgent vascular surgery');


CREATE TABLE IF NOT EXISTS doctor (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    mobile_phone VARCHAR(20) NOT NULL,
    office_phone VARCHAR(20) NOT NULL,
    ward_code VARCHAR(50) NOT NULL,
    insert_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (ward_code) REFERENCES ward(ward_code)
);
CREATE SEQUENCE IF NOT EXISTS sq_doctor_id;
INSERT INTO doctor (id, name, surname, email, mobile_phone, office_phone, ward_code) VALUES (sq_doctor_id.nextval, 'Giuseppe', 'Rossi', 'giuseppe.rossi@openhospital.com', '+393332211555', '+3920120000111', 'OH-0001');
INSERT INTO doctor (id, name, surname, email, mobile_phone, office_phone, ward_code) VALUES (sq_doctor_id.nextval, 'Roberto', 'Rossi', 'roberto.rossi@openhospital.com', '+393332211555', '+3920120000111','OH-0001');
INSERT INTO doctor (id, name, surname, email, mobile_phone, office_phone, ward_code) VALUES (sq_doctor_id.nextval, 'Marco', 'Ferrari', 'marco.ferrari@openhospital.com', '+393332211555', '+3920120000111', 'OH-0002');
INSERT INTO doctor (id, name, surname, email, mobile_phone, office_phone, ward_code) VALUES (sq_doctor_id.nextval, 'Martina', 'Russo', 'martina.russo@openhospital.com', '+393332211555', '+3920120000111', 'OH-0002');
INSERT INTO doctor (id, name, surname, email, mobile_phone, office_phone, ward_code) VALUES (sq_doctor_id.nextval, 'Giuseppe', 'Bianchi', 'giuseppe.bianchi@openhospital.com', '+393332211555', '+3920120000111', 'OH-0002');
INSERT INTO doctor (id, name, surname, email, mobile_phone, office_phone, ward_code) VALUES (sq_doctor_id.nextval, 'Anna', 'Romano', 'anna.romano@openhospital.com', '+393332211555', '+3920120000111', 'OH-0002');


CREATE TABLE IF NOT EXISTS medical_service (
    id INT PRIMARY KEY,
    doctor_id INT NOT NULL,
    health_id INT NOT NULL,
    insert_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (doctor_id) REFERENCES doctor(id),
    FOREIGN KEY (health_id) REFERENCES health(id)
);
CREATE SEQUENCE IF NOT EXISTS sq_medical_service_id;
INSERT INTO medical_service (id, doctor_id, health_id) VALUES (sq_medical_service_id.nextval, 1, 1);
INSERT INTO medical_service (id, doctor_id, health_id) VALUES (sq_medical_service_id.nextval, 1, 2);
INSERT INTO medical_service (id, doctor_id, health_id) VALUES (sq_medical_service_id.nextval, 1, 3);
INSERT INTO medical_service (id, doctor_id, health_id) VALUES (sq_medical_service_id.nextval, 2, 1);
INSERT INTO medical_service (id, doctor_id, health_id) VALUES (sq_medical_service_id.nextval, 3, 2);
INSERT INTO medical_service (id, doctor_id, health_id) VALUES (sq_medical_service_id.nextval, 4, 2);
INSERT INTO medical_service (id, doctor_id, health_id) VALUES (sq_medical_service_id.nextval, 5, 3);
INSERT INTO medical_service (id, doctor_id, health_id) VALUES (sq_medical_service_id.nextval, 6, 1);


CREATE TABLE IF NOT EXISTS proposal (
    id INT PRIMARY KEY,
    product_type VARCHAR(10) NOT NULL,
    product_code VARCHAR(10) NOT NULL,
    check_in TIMESTAMP,
    price NUMERIC(10, 2) NOT NULL,
    status CHAR(1) NOT NULL DEFAULT 'F',
    insert_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE SEQUENCE IF NOT EXISTS sq_proposal_id;


CREATE TABLE IF NOT EXISTS reservation (
    id INT PRIMARY KEY,
    proposal_id INT NOT NULL,
    product_type VARCHAR(10) NOT NULL,
    product_code VARCHAR(10) NOT NULL,
    check_in TIMESTAMP,
    price NUMERIC(10, 2) NOT NULL,
    status CHAR(1) NOT NULL DEFAULT 'F',
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    insert_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (proposal_id) REFERENCES proposal(id)
);
CREATE SEQUENCE sq_reservation_id;