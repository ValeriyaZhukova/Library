-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2020 at 05:20 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`id`, `name`, `surname`) VALUES
(1, 'John', 'Tolkien'),
(2, 'Mikhail', 'Lermontov'),
(3, 'Mikhail', 'Bulgakov'),
(4, 'Neil', 'Gaiman'),
(5, 'Terry', 'Pratchett');

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` bigint(20) NOT NULL,
  `category` tinyblob,
  `language` varchar(255) DEFAULT NULL,
  `publication_year` int(11) NOT NULL,
  `status` tinyblob,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `category`, `language`, `publication_year`, `status`, `title`) VALUES
(2, 0xaced00057e7200226b7a2e696974752e6c6962726172792e6d6f64656c2e426f6f6b43617465676f727900000000000000001200007872000e6a6176612e6c616e672e456e756d0000000000000000120000787074000746494354494f4e, 'English', 1954, 0xaced00057e7200206b7a2e696974752e6c6962726172792e6d6f64656c2e426f6f6b53746174757300000000000000001200007872000e6a6176612e6c616e672e456e756d00000000000000001200007870740009415641494c41424c45, 'Fellowship of the Ring'),
(3, 0xaced00057e7200226b7a2e696974752e6c6962726172792e6d6f64656c2e426f6f6b43617465676f727900000000000000001200007872000e6a6176612e6c616e672e456e756d0000000000000000120000787074000746494354494f4e, 'English', 1997, 0xaced00057e7200206b7a2e696974752e6c6962726172792e6d6f64656c2e426f6f6b53746174757300000000000000001200007872000e6a6176612e6c616e672e456e756d00000000000000001200007870740006495353554544, 'Stardust'),
(4, 0xaced00057e7200226b7a2e696974752e6c6962726172792e6d6f64656c2e426f6f6b43617465676f727900000000000000001200007872000e6a6176612e6c616e672e456e756d0000000000000000120000787074000550524f5345, 'Russian', 1967, 0xaced00057e7200206b7a2e696974752e6c6962726172792e6d6f64656c2e426f6f6b53746174757300000000000000001200007872000e6a6176612e6c616e672e456e756d00000000000000001200007870740009524551554553544544, 'Master and Margarita'),
(5, 0xaced00057e7200226b7a2e696974752e6c6962726172792e6d6f64656c2e426f6f6b43617465676f727900000000000000001200007872000e6a6176612e6c616e672e456e756d000000000000000012000078707400054452414d41, 'Russian', 1840, 0xaced00057e7200206b7a2e696974752e6c6962726172792e6d6f64656c2e426f6f6b53746174757300000000000000001200007872000e6a6176612e6c616e672e456e756d000000000000000012000078707400074f564552445545, 'A hero of our time'),
(6, 0xaced00057e7200226b7a2e696974752e6c6962726172792e6d6f64656c2e426f6f6b43617465676f727900000000000000001200007872000e6a6176612e6c616e672e456e756d0000000000000000120000787074000746494354494f4e, 'English', 1990, 0xaced00057e7200206b7a2e696974752e6c6962726172792e6d6f64656c2e426f6f6b53746174757300000000000000001200007872000e6a6176612e6c616e672e456e756d00000000000000001200007870740009415641494c41424c45, 'Good Omens'),
(7, 0xaced00057e7200226b7a2e696974752e6c6962726172792e6d6f64656c2e426f6f6b43617465676f727900000000000000001200007872000e6a6176612e6c616e672e456e756d0000000000000000120000787074000746494354494f4e, 'English', 1983, 0xaced00057e7200206b7a2e696974752e6c6962726172792e6d6f64656c2e426f6f6b53746174757300000000000000001200007872000e6a6176612e6c616e672e456e756d00000000000000001200007870740009415641494c41424c45, 'The Colour of Magic');

-- --------------------------------------------------------

--
-- Table structure for table `book_authors`
--

CREATE TABLE `book_authors` (
  `book_id` bigint(20) NOT NULL,
  `author_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `book_authors`
--

INSERT INTO `book_authors` (`book_id`, `author_id`) VALUES
(2, 1),
(3, 4),
(4, 3),
(5, 2),
(7, 5),
(6, 4),
(6, 5);

-- --------------------------------------------------------

--
-- Table structure for table `book_genres`
--

CREATE TABLE `book_genres` (
  `book_id` bigint(20) NOT NULL,
  `genre_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `book_genres`
--

INSERT INTO `book_genres` (`book_id`, `genre_id`) VALUES
(2, 2),
(3, 2),
(4, 1),
(4, 2),
(4, 5),
(4, 6),
(5, 1),
(5, 4),
(7, 2),
(7, 3),
(6, 2),
(6, 3);

-- --------------------------------------------------------

--
-- Table structure for table `book_issue`
--

CREATE TABLE `book_issue` (
  `id` bigint(20) NOT NULL,
  `book_id` bigint(20) DEFAULT NULL,
  `due_date` datetime DEFAULT NULL,
  `is_overdue` bit(1) NOT NULL,
  `issue_date` datetime DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `book_request`
--

CREATE TABLE `book_request` (
  `id` bigint(20) NOT NULL,
  `book_id` bigint(20) DEFAULT NULL,
  `is_issued` bit(1) NOT NULL,
  `request_date` datetime DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--

CREATE TABLE `genre` (
  `id` bigint(20) NOT NULL,
  `genre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `genre`
--

INSERT INTO `genre` (`id`, `genre`) VALUES
(1, 'Novel'),
(2, 'Fantasy'),
(3, 'Comedy'),
(4, 'Psychological realism'),
(5, 'Farce'),
(6, 'Satire'),
(7, 'Horror'),
(8, 'Detective fiction');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `role`) VALUES
(1, 'USER'),
(2, 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `password`, `username`) VALUES
(1, '$2a$10$e3jH8hpBS1.rgEgdjL3BIeiZq5dQq95lE4m3BnId8DPOBH39wORbe', 'lera'),
(2, '$2a$10$xISe3aitjxUIFYzy0Hmb7uQzViN3DXfap7bQm0jTxujxXv.q3c2ji', 'john'),
(3, '$2a$10$D4EAbuBUUYfDPNPxncCNde/uJejDXoIMw7Up5qd2aQe8zRMhOP2aC', 'user'),
(4, '$2a$10$7u/iRyO9hYdYoinOFr/tberHKShQEq2HWUV6PmbpsdjK.CyoQi6/y', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book_authors`
--
ALTER TABLE `book_authors`
  ADD KEY `FK78gu95lglhc6cs2u5jfudx6e5` (`author_id`),
  ADD KEY `FKs4xm7q8i3uxvaiswj1c35nnxw` (`book_id`);

--
-- Indexes for table `book_genres`
--
ALTER TABLE `book_genres`
  ADD KEY `FK9h3nddtxgapfvc95fjt1x146m` (`genre_id`),
  ADD KEY `FK6soimqwnss59p5wt6m3afnuoo` (`book_id`);

--
-- Indexes for table `book_issue`
--
ALTER TABLE `book_issue`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3icc83tqrycfhc7j1bcg5b68j` (`book_id`),
  ADD KEY `FKm81ndnr9ksmyagwmwrexd6puy` (`user_id`);

--
-- Indexes for table `book_request`
--
ALTER TABLE `book_request`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfx1qamnoxvms7v5i9ktmyv69d` (`book_id`),
  ADD KEY `FKil177jq2hx4sl9ksmrxk1j4ct` (`user_id`);

--
-- Indexes for table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD KEY `FKrhfovtciq1l558cw6udg0h0d3` (`role_id`),
  ADD KEY `FK55itppkw3i07do3h7qoclqd4k` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `book_issue`
--
ALTER TABLE `book_issue`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `book_request`
--
ALTER TABLE `book_request`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book_authors`
--
ALTER TABLE `book_authors`
  ADD CONSTRAINT `FK78gu95lglhc6cs2u5jfudx6e5` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
  ADD CONSTRAINT `FKs4xm7q8i3uxvaiswj1c35nnxw` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`);

--
-- Constraints for table `book_genres`
--
ALTER TABLE `book_genres`
  ADD CONSTRAINT `FK6soimqwnss59p5wt6m3afnuoo` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `FK9h3nddtxgapfvc95fjt1x146m` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`);

--
-- Constraints for table `book_issue`
--
ALTER TABLE `book_issue`
  ADD CONSTRAINT `FK3icc83tqrycfhc7j1bcg5b68j` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `FKm81ndnr9ksmyagwmwrexd6puy` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `book_request`
--
ALTER TABLE `book_request`
  ADD CONSTRAINT `FKfx1qamnoxvms7v5i9ktmyv69d` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `FKil177jq2hx4sl9ksmrxk1j4ct` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FK55itppkw3i07do3h7qoclqd4k` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKrhfovtciq1l558cw6udg0h0d3` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
