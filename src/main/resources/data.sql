INSERT INTO publisher (name) VALUES ( 'edition lamartine' );
INSERT INTO book (isbn , description ,image ,  title, year , category , publisher_id_publisher) VALUES ( '1234' , 'un livre avec isbn 1234' ,
                                                                    'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQPnqLg-ZNDp-gCozCKJcC_dCNJp_rhRMAyLw&usqp=CAU',
                                                                    'Le joli titre' ,
                                                                    '2017' ,
                                                                     'BD' ,
                                                                    SELECT id_publisher FROM publisher WHERE name = 'edition lamartine' );
INSERT INTO author (firstname , lastname) VALUES ( 'Paul' , 'Robinson' );
INSERT INTO library (address , library_name , opening_hours ) VALUES ( 'rue untel' , 'Vite vite' , '14h-15h' );

INSERT INTO stock(id_book, id_library ,label , column , shelf , wings) VALUES (SELECT id_book FROM book WHERE isbn = '1234',
                                                                            SELECT id_library FROM library where library_name = 'Vite vite'
                                                                            , 'UTF1234' , '54a0' , '2A' , 'allee E' );
INSERT INTO topic (keyword) VALUES ( 'escalade' );
INSERT INTO book_author (id_book ,id_author) VALUES ( SELECT id_book FROM book WHERE isbn = '1234' , SELECT id_author from author where firstname = 'Paul');
INSERT INTO book_topics (id_book ,id_topics) VALUES ( SELECT id_book FROM book WHERE isbn = '1234' , SELECT id_topic from topic where keyword = 'escalade');


INSERT INTO topic (keyword) VALUES ( 'informatique' ) , ('maven') , ('java') , ('asterix') , ('obelix'),
                                   ('anneau'), ('fantastique');


INSERT INTO publisher (name) VALUES ( 'Pocket' );
INSERT INTO publisher (name) VALUES ( 'Gallimard jeunesse' );
INSERT INTO publisher (name) VALUES ( 'ENI Editions' );
INSERT INTO publisher (name) VALUES ( 'Albert Rene' );

INSERT INTO author (firstname , lastname) VALUES ( 'Rene' , 'Goscinny' );
INSERT INTO author (firstname , lastname) VALUES ( 'Albert' , 'Uderzo' );
INSERT INTO author (firstname , lastname) VALUES ( 'Didier' , 'Conrad' );
INSERT INTO author (firstname , lastname) VALUES ( 'Jean-Yves' , 'Ferri' );
INSERT INTO author (firstname , lastname) VALUES ( 'JRR' , 'Tolkien' );
INSERT INTO author (firstname , lastname) VALUES ( 'Etienne' , 'Langlet' );
INSERT INTO author (firstname , lastname) VALUES ( 'Maxime' , 'Gréau' );

INSERT INTO library (address , library_name , opening_hours ) VALUES ( 'rue autre' , 'Grande librairie de la ville' , '9h-21h' );
INSERT INTO library (address , library_name , opening_hours ) VALUES ( 'rue encore une' , 'La 3eme de la ville' , '8h-12h  14h-18h' );

INSERT INTO book (isbn , description ,image ,  title, year , category , publisher_id_publisher) VALUES ( '2409019536' , 'Apache Maven la description ......' ,
                                                                                                      'https://static.fnac-static.com/multimedia/Images/FR/NR/0e/96/a9/11113998/1507-1/tsp20190606164132/Apache-Maven.jpg',
                                                                                                      'Apache Maven' ,
                                                                                                      '2019' ,
                                                                                                      'LOISIRS' ,
                                                                                                      SELECT id_publisher FROM publisher WHERE name = 'ENI Editions' );
INSERT INTO stock(id_book, id_library ,label , column , shelf , wings) VALUES (SELECT id_book FROM book WHERE isbn = '2409019536',
                                                                               SELECT id_library FROM library where library_name = 'Vite vite'
                                                                                  , 'UTF1234' , '54a0' , '2A' , 'allee E' );
INSERT INTO book_author (id_book ,id_author) VALUES ( SELECT id_book FROM book WHERE isbn = '2409019536' , SELECT id_author from author where firstname = 'Etienne'),
                                                    ( SELECT id_book FROM book WHERE isbn = '2409019536' , SELECT id_author from author where firstname = 'Maxime');
INSERT INTO book_topics (id_book ,id_topics) VALUES ( SELECT id_book FROM book WHERE isbn = '2409019536' , SELECT id_topic from topic where keyword = 'maven'),
                                                    ( SELECT id_book FROM book WHERE isbn = '2409019536' , SELECT id_topic from topic where keyword = 'informatique'),
                                                    ( SELECT id_book FROM book WHERE isbn = '2409019536' , SELECT id_topic from topic where keyword = 'java');

INSERT INTO book (isbn , description ,image ,  title, year , category , publisher_id_publisher) VALUES ( '2864973235' , 'Asterix papyrus description ......' ,
                                                                                                         'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQPnqLg-ZNDp-gCozCKJcC_dCNJp_rhRMAyLw&usqp=CAU',
                                                                                                         'Asterix : le Papyrus de César' ,
                                                                                                         '2015' ,
                                                                                                         'BD' ,
                                                                                                         SELECT id_publisher FROM publisher WHERE name = 'Albert Rene' );
INSERT INTO stock(id_book, id_library ,label , column , shelf , wings) VALUES (SELECT id_book FROM book WHERE isbn = '2864973235',
                                                                               SELECT id_library FROM library where library_name = 'Vite vite'
                                                                                  , 'UTF1234' , '54a0' , '2A' , 'allee E' );
INSERT INTO book_author (id_book ,id_author) VALUES ( SELECT id_book FROM book WHERE isbn = '2864973235' , SELECT id_author from author where firstname = 'Jean-Yves'),
                                                    ( SELECT id_book FROM book WHERE isbn = '2864973235' , SELECT id_author from author where firstname = 'Rene'),
                                                    ( SELECT id_book FROM book WHERE isbn = '2864973235' , SELECT id_author from author where firstname = 'Albert'),
                                                    ( SELECT id_book FROM book WHERE isbn = '2864973235' , SELECT id_author from author where firstname = 'Didier');
INSERT INTO book_topics (id_book ,id_topics) VALUES ( SELECT id_book FROM book WHERE isbn = '2864973235' , SELECT id_topic from topic where keyword = 'asterix'),
                                                    ( SELECT id_book FROM book WHERE isbn = '2864973235' , SELECT id_topic from topic where keyword = 'obelix');