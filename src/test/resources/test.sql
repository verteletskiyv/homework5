DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS genre;

CREATE TABLE genre
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE book
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    author VARCHAR(100) NOT NULL,
    title VARCHAR(100) NOT NULL,
    year_written INT NOT NULL,
    genre_id BIGINT,
    CONSTRAINT FKm1t3yvw5i7olwdf32cwuul7ta
        FOREIGN KEY (genre_id) REFERENCES genre (id)
);

INSERT INTO genre(name)
VALUES ('Fantasy'),
       ('Horror'),
       ('Thriller'),
       ('Poetry'),
       ('Drama'),
       ('Historical'),
       ('Romance'),
       ('Western'),
       ('Biography');

INSERT INTO book(title, author, year_written, genre_id)
VALUES ('Moby Dick', 'Herman Melville', 1851, 5),
       ('Ulysses', 'James Joyce', 1904, 6),
       ('Don Quixote', 'Miguel de Cervantes', 1605, 1),
       ('The Great Gatsby', 'F. Scott Fitzgerald', 1924, 9),
       ('Hamlet', 'William Shakespeare', 1599, 4),
       ('The Odyssey', 'Homer', 1614, 4),
       ('The Catcher in the Rye', 'J. D. Salinger', 1945, 5),
       ('Pride and Prejudice', 'Jane Austen', 1813, 7),
       ('Alice''s Adventures in Wonderland', 'Lewis Carroll', 1862, 1),
       ('Catch-22', 'Joseph Heller', 1961, 3),
       ('Nineteen Eighty Four', 'George Orwell', 1949, 3),
       ('To Kill a Mockingbird', 'Harper Lee', 1960, 5),
       ('The Prince', 'Niccolo Machiavelli', 1513, 9),
       ('In Cold Blood', 'Truman Capote', 1965, 2),
       ('Democracy in America', 'Alexis de Tocqueville', 1835, 6),
       ('The Second World War', 'Winston Churchill', 1948, 6),
       ('The Lord of the Rings', 'J. R. R. Tolkien', 1954, 1),
       ('Frankenstein', 'Mary Shelley', 1818, 2),
       ('On the Road', 'Jack Kerouac', 1957, 3),
       ('The Grapes of Wrath', 'John Steinbeck', 1939, 8),
       ('East of Eden', 'John Steinbeck', 1952, 8),
       ('Iliad', 'Homer', 1598, 4),
       ('Odyssey', 'Homer', 1614, 4),
       ('Life of Homer', 'Homer', 0, 9),
       ('In Dubious Battle', 'John Steinbeck', 1936, 5),
       ('Of Mice and Men', 'John Steinbeck', 1937, 5),
       ('Travels with Charley', 'John Steinbeck', 1960, 4),
       ('Cup of Gold', 'John Steinbeck', 1929, 1),
       ('Their Blood Is Strong', 'John Steinbeck', 1938, 6),
       ('Steinbeck in Vietnam: Dispatches from the War', 'John Steinbeck', 2012, 9),
       ('Steinbeck: A Life in Letters', 'John Steinbeck', 1975, 9),
       ('Bombs Away: The Story of a Bomber Team', 'John Steinbeck', 1942, 6),
       ('The Road', 'Jack London', 1907, 9),
       ('The Cruise of the Snark', 'Jack London', 1911, 9),
       ('John Barleycorn', 'Jack London', 1913, 9),
       ('Editorial Crimes – A Protest', 'Jack London', 1901, 6),
       ('The People of the Abyss ', 'Jack London', 1903, 6),
       ('Mexico''s Army and Ours', 'Jack London', 1914, 6),
       ('Abalone Song', 'Jack London', 1913, 4),
       ('Homeland', 'Jack London', 1914, 4),
       ('Ballade of the False Lover', 'Jack London', 1914, 4),
       ('The Sea Sprite and the Shooting Star', 'Jack London', 1916, 4),
       ('The Worker and the Tramp', 'Jack London', 1911, 4),
       ('When All the World Shouted my Name', 'Jack London', 1905, 4),
       ('The Sea-Wolf ', 'Jack London', 1904, 5),
       ('Martin Eden', 'Jack London', 1909, 7),
       ('The Scarlet Plague', 'Jack London', 1912, 1),
       ('Hearts of Three', 'Jack London', 1920, 4),
       ('The Assassination Bureau, Ltd', 'Jack London', 1963, 3),
       ('Typhoon off the Coast of Japan', 'Jack London', 1893, 2),
       ('The Plague Ship', 'Jack London', 1897, 3),
       ('The Devil’s Dice Box', 'Jack London', 1898, 2),
       ('To the Man on Trail: A Klondike Christmas', 'Jack London', 1913, 8),
       ('A Son of the Sun', 'Jack London', 1912, 1),
       ('The Star Rover', 'Jack London', 1915, 1),
       ('Through the Rapids on the Way to the Klondike', 'Jack London', 1899, 6),
       ('A Northland Miracle', 'Jack London', 1900, 1),
       ('The Little Lady of the Big House', 'Jack London', 1916, 7),
       ('Michael, Brother of Jerry', 'Jack London', 1913, 7),
       ('O Haru', 'Jack London', 1897, 8),
       ('A Klondike Christmas', 'Jack London', 1898, 8);