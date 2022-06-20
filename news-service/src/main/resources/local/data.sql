--cleaning structure
DROP TABLE IF EXISTS news;
DROP SEQUENCE IF EXISTS sq_news_id;

-- reimport data
CREATE TABLE IF NOT EXISTS news (
    id INT PRIMARY KEY,
    lang VARCHAR(2) NOT NULL,
    institution VARCHAR(50) NOT NULL,
    institution_image VARCHAR(50) NOT NULL,
    title VARCHAR(100) NOT NULL,
    short_description VARCHAR(300) NOT NULL,
    description VARCHAR(1500) NOT NULL,
    image VARCHAR(500) NOT NULL,
    link VARCHAR(500) NOT NULL,
    clickable BOOLEAN NOT NULL DEFAULT TRUE,
    insert_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    enabled BOOLEAN NOT NULL DEFAULT TRUE
);
CREATE SEQUENCE IF NOT EXISTS sq_news_id;
INSERT INTO news (id, lang, institution, institution_image, title, short_description, description, image, link, clickable, enabled)
        VALUES (sq_news_id.nextval, 'it', 'Ministero della Salute', 'https://dummyimage.com/40x40/ced4da/6c757d', 'Vaccinazione Covid-19', ' ', ' ', 'https://dummyimage.com/600x350/ced4da/6c757d', 'https://test.com', false, true);
INSERT INTO news (id, lang, institution, institution_image, title, short_description, description, image, link, clickable, enabled)
        VALUES (sq_news_id.nextval, 'it', 'Ministero della Salute', 'https://dummyimage.com/40x40/ced4da/6c757d', 'Terza dose vaccino anti-Covid', 'Cambiano le tempistiche della terza dose. Da mercoled&igrave; 24 novembre sar&agrave; possibile ricevere il richiamo della vaccinazione anti Covid-19 anche a distanza di 5 mesi dall&apos;ultimo vaccino ricevuto.', ' ', 'https://dummyimage.com/600x350/ced4da/6c757d', 'https://test.com', false, true);
INSERT INTO news (id, lang, institution, institution_image, title, short_description, description, image, link, clickable, enabled)
        VALUES (sq_news_id.nextval, 'it', 'Ministero della Salute', 'https://dummyimage.com/40x40/ced4da/6c757d', 'Obbligo vaccinale OVER-50', 'Dall&apos;8 gennaio &egrave; in vigore la misura prevista dal decreto legge 5 gennaio 2022 che prevede l&apos;obbligo vaccinale per tutti gli over 50. L&apos;obbligo riguarda italiani e stranieri residenti in Italia.', ' ', 'https://dummyimage.com/600x350/ced4da/6c757d', 'https://test.com', false, true);
INSERT INTO news (id, lang, institution, institution_image, title, short_description, description, image, link, clickable, enabled)
        VALUES (sq_news_id.nextval, 'en', 'Ministry of Health', 'https://dummyimage.com/40x40/ced4da/6c757d', 'Covid-19 vaccination', ' ', ' ', 'https://dummyimage.com/600x350/ced4da/6c757d', 'https://test.com', false, true);
INSERT INTO news (id, lang, institution, institution_image, title, short_description, description, image, link, clickable, enabled)
        VALUES (sq_news_id.nextval, 'en', 'Ministry of Health', 'https://dummyimage.com/40x40/ced4da/6c757d', 'Third dose anti-Covid vaccine', 'The timing of the third dose changes. From Wednesday 24 November it will be possible to receive the recall of the anti Covid-19 vaccination even after 5 months from the last vaccine received.', ' ', 'https://dummyimage.com/600x350/adb5bd/495057', 'https://test.com', false, true);
INSERT INTO news (id, lang, institution, institution_image, title, short_description, description, image, link, clickable, enabled)
        VALUES (sq_news_id.nextval, 'en', 'Ministry of Health', 'https://dummyimage.com/40x40/ced4da/6c757d', 'OVER-50 vaccination obligation', 'From January 8, the measure provided for by the decree law of January 5, 2022, which provides for the vaccination obligation for all over 50s, is in force. The obligation applies to Italians and foreigners residing in Italy.', ' ', 'https://dummyimage.com/600x350/6c757d/343a40', 'https://test.com', false, true);
