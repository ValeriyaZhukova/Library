-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 05, 2020 at 04:58 PM
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
(6, 0xaced00057e7200226b7a2e696974752e6c6962726172792e6d6f64656c2e426f6f6b43617465676f727900000000000000001200007872000e6a6176612e6c616e672e456e756d000000000000000012000078707400054452414d41, 'English', 1990, 0xaced00057e7200206b7a2e696974752e6c6962726172792e6d6f64656c2e426f6f6b53746174757300000000000000001200007872000e6a6176612e6c616e672e456e756d00000000000000001200007870740009415641494c41424c45, 'Good omens'),
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
(6, 4),
(6, 5),
(7, 5);

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
(6, 2),
(6, 3),
(6, 7),
(7, 2),
(7, 3);

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

--
-- Dumping data for table `book_issue`
--

INSERT INTO `book_issue` (`id`, `book_id`, `due_date`, `is_overdue`, `issue_date`, `user_id`) VALUES
(1, 3, '2020-04-25 00:00:00', b'0', '2020-03-25 00:00:00', 2),
(2, 5, '2020-04-04 00:00:00', b'1', '2020-03-04 00:00:00', 5);

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

--
-- Dumping data for table `book_request`
--

INSERT INTO `book_request` (`id`, `book_id`, `is_issued`, `request_date`, `user_id`) VALUES
(1, 3, b'1', '2020-03-20 00:00:00', 2),
(2, 4, b'0', '2020-03-30 00:00:00', 7);

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
(7, 'Horror');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `role_id`, `surname`) VALUES
(2, 'Valeriya', 1, 'Zhukova'),
(3, 'John', 1, 'Smith'),
(4, 'Georgia', 1, 'Foster'),
(5, 'Kate', 1, 'Austin'),
(6, 'James', 1, 'Ford'),
(7, 'John', 1, 'Locke'),
(8, 'Arthur', 2, 'Barker');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`id`, `role`) VALUES
(1, 'Member'),
(2, 'Librarian');

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
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_user_role_id_fk` (`role_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `book_issue`
--
ALTER TABLE `book_issue`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `book_request`
--
ALTER TABLE `book_request`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `user_role`
--
ALTER TABLE `user_role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FKn4pb12f3y8ktduy8fnc2xlln1` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`id`),
  ADD CONSTRAINT `user_user_role_id_fk` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
