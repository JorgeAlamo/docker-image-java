INSERT INTO author (name, email, phone, birthdate) VALUES ('Carlos L. Ives', 'CarlosLIves@gustggr.com', '408-624-2968', '1936-10-25');
INSERT INTO author (name, email, phone, birthdate) VALUES ('Harry P. Carr', 'HarryPCarr@gustggr.com', '830-262-9435', '1984-08-29');
INSERT INTO author (name, email, phone, birthdate) VALUES ('Charles J. Bender', 'CharlesJBender@gustggr.com', '970-364-9563', '1953-07-17');
INSERT INTO author (name, email, phone, birthdate) VALUES ('Mark R. Castle', 'MarkRCastle@gustggr.com', '460-954-6932', '1993-03-01');
INSERT INTO author (name, email, phone, birthdate) VALUES ('Kris A. Burchett', 'KrisABurchett@gustggr.com', '330-744-9813', '2005-11-21');

INSERT INTO blog (author_id, name, description, url, status) VALUES (1, 'Live Apple Event - Apple September Event 2017 - iPhone 8, iPhone X, iOS 11 - Apple Keynote', 'apple events|apple event|iphone 8|iphone x|iphone 8 plus|iphone 7s|iphone 7s plus|ios 11', 'https://i.ytimg.com/vi/WoPtuVbaSKQ/default.jpg', 'activo');
INSERT INTO blog (author_id, name, description, url, status) VALUES (1, 'Holly and Phillip Meet Samantha the Sex Robot | This Morning', 'this morning|interview|holly willoughby|phillip schofield|ruth langsford|eamonn holmes|chat shows - ...', 'https://i.ytimg.com/vi/3-yamPXZQtU/default.jpg', 'inactivo');
INSERT INTO blog (author_id, name, description, url, status) VALUES (2, 'My DNA Test Results! Im WHAT?!', 'emmablackery|emma blackery|emma|blackery|british vlogger|british youtuber|female vlogger|birdyboots|...', 'https://i.ytimg.com/vi/zcqZHYo7ONs/default.jpg', 'activo');
INSERT INTO blog (author_id, name, description, url, status) VALUES (2, 'getting into a conversation in a language you dont actually speak that well', 'skit|korean|language|conversation|esl|japanese|foreign|communication|dont speak|struggle|foreigner|...', 'https://i.ytimg.com/vi/DUFBEamEF0Q/default.j', 'inactivo');
INSERT INTO blog (author_id, name, description, url, status) VALUES (3, 'REVEALED - FIFA 18 stats for Chelseas Hazard, Luiz & Christensen!', 'how to|cooking|recipe|kitchen|chicken|chicken breast|juicy chicken breast|baked chicken breast|hummu...', 'https://i.ytimg.com/vi/JsTptu56GM8/default.jpg', 'activo');
INSERT INTO blog (author_id, name, description, url, status) VALUES (3, 'Juicy Chicken Breast - You Suck at Cooking (episode 65)', 'dude perfect|dude perfect stereotypes|dude perfect water bottle flip|bottle flip|water bottle flip|d...', 'https://i.ytimg.com/vi/nZHZMVlc9A0/default.jpg', 'inactivo');
INSERT INTO blog (author_id, name, description, url, status) VALUES (3, 'Action Bronson and Sean Evans Have a Sandwich Showdown, Judged by Mario Batali | Sean in the Wild', 'First we feast|fwf|firstwefeast|food|food porn|cook|cooking|chef|kitchen|recipe|cocktail|bartender|c...', 'https://i.ytimg.com/vi/X0U8Awfizoc/default.jpg', 'activo');
INSERT INTO blog (author_id, name, description, url, status) VALUES (4, 'Whats Actually the Plane of the Future', 'nile wilson|nile wilson gymnastics|nile wilson olympics|olympic gymnast|amazing gymnastics|gymnastic...', 'https://i.ytimg.com/vi/bp6uJJJMaLs/default.jpg','inactivo');
INSERT INTO blog (author_id, name, description, url, status) VALUES (4, 'Drowning for Power - Rooster Teeth Animated Adventures', 'samantha|maria|sammi|shopping|fenty|beauty|back|at|the|gym|handmaids|tale', 'https://i.ytimg.com/vi/wP97gsUp4cM/default.jpg', 'activo');

INSERT INTO post (blog_id, title, date, status, content) VALUES (1, 'Taken at the Flood','1912-07-25', 'borrador', 'One of Sidney Sheldons most popular and bestselling titles, repackaged and reissued for a new gener...');
INSERT INTO post (blog_id, title, date, status, content) VALUES (2, 'The voyage of the Dawn Treader','1983-03-07', 'publicado', 'Kate Blackwell is an enigma and one of the most powerful women in the world. But at her ninetieth bi...');
INSERT INTO post (blog_id, title, date, status, content) VALUES (3, 'Heart Songs and Other Stories','1943-08-14', 'borrador', 'A new-cover reissue of the fourth book in the bestselling five-volume sf series created by the world...');
INSERT INTO post (blog_id, title, date, status, content) VALUES (4, 'The Wee Free Men','1994-09-27', 'publicado', 'Emma Watson a research physician has been training for the mission of a lifetime: to study living or...');
INSERT INTO post (blog_id, title, date, status, content) VALUES (5, 'Mars and Venus Book of Days','1982-10-05', 'borrador', 'Spares - human clones, the ultimate health insurance. An eye for an eye - but some people are doing ...');
INSERT INTO post (blog_id, title, date, status, content) VALUES (5, 'The Last of the Really Great Whangdoodles','1958-10-30', 'publicado', 'Miss Marple featured in 20 short stories, published in a number of different collections in Britain ...');
INSERT INTO post (blog_id, title, date, status, content) VALUES (5, 'The Forever War','2006-04-15', 'borrador', 'Sauron has gathered the Rings of Power - the means by which he will be able to rule the world. All h...');
INSERT INTO post (blog_id, title, date, status, content) VALUES (6, 'A Nose for Murder','2015-02-24', 'publicado', 'A young drifter finds more than he bargained for when he agrees to deliver a parcel to an English co...');
INSERT INTO post (blog_id, title, date, status, content) VALUES (7, 'The Kindness of Strangers','2001-01-27', 'borrador', 'In an absorbing narrative about personalities and social history, Menand discusses the Metaphysical ...');
INSERT INTO post (blog_id, title, date, status, content) VALUES (8, 'The Black Dahlia Files','2021-12-30', 'publicado', 'Suggests a theory of presidential power, and tests it against the events in the administrations of t...');
INSERT INTO post (blog_id, title, date, status, content) VALUES (8, 'Touching the Void','1972-11-12', 'borrador', 'A blending of scholarly research and interviews with many of the figures who launched the civil righ...');
INSERT INTO post (blog_id, title, date, status, content) VALUES (9, 'The Problem of Pain','2017-08-19', 'publicado', 'Armed with the latest gifts of advanced technology, a California scientist, a ruthless corporation a...');

INSERT INTO comment (post_id, date, name, state) VALUES (2, '2010-09-22','Its more accurate to call it the M+ (1000) because the price is closer than calling it the X (10).', 'publicado');
INSERT INTO comment (post_id, date, name, state) VALUES (2, '2010-10-23','They really just took the samsung s8 and named it iphone x or whatever', 'actualizado');
INSERT INTO comment (post_id, date, name, state) VALUES (4, '2013-03-22','For god sake its better than my ps4pro', 'publicado');
INSERT INTO comment (post_id, date, name, state) VALUES (4, '2014-06-16','you can keep looking at it , time to time. They will keep updating it.', 'actualizado');
INSERT INTO comment (post_id, date, name, state) VALUES (4, '2015-07-21','i was actually interested in this...and then you said how much it was lol', 'publicado');
INSERT INTO comment (post_id, date, name, state) VALUES (6, '2015-09-08','It is a conspiracy.... It is the NWO collecting everyones generic data so they know who to clone an...', 'actualizado');
INSERT INTO comment (post_id, date, name, state) VALUES (8, '2015-11-22','northwestern european is pretty vague cause that would include UK as well', 'publicado');
INSERT INTO comment (post_id, date, name, state) VALUES (8, '2017-04-02','Her genetics are pure, we must breed her!', 'actualizado');
INSERT INTO comment (post_id, date, name, state) VALUES (8, '2017-09-28','Why people call themselves a certain nationality if they dont even know the language?', 'publicado');
INSERT INTO comment (post_id, date, name, state) VALUES (8, '2019-12-01','Im sure hazard already googled his', 'actualizado');
INSERT INTO comment (post_id, date, name, state) VALUES (10, '2020-02-06','See even the footballers say the rating is wrong', 'publicado');
INSERT INTO comment (post_id, date, name, state) VALUES (10, '2020-07-31','I was curious to see where that ladybug was gonna go.', 'actualizado');
INSERT INTO comment (post_id, date, name, state) VALUES (10, '2020-11-11','That juice is really the salt water that gets injected into the dead bird youre about to eat. The b...', 'publicado');
INSERT INTO comment (post_id, date, name, state) VALUES (10, '2020-12-20','I can only imagine how many times they had to film that pool table trick shot.', 'actualizado');
INSERT INTO comment (post_id, date, name, state) VALUES (12, '2021-03-01','Lets just say their engineers', 'publicado');


