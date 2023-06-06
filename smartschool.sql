-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Gegenereerd op: 06 jun 2023 om 13:29
-- Serverversie: 8.0.30
-- PHP-versie: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smartschool`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `absence`
--

CREATE TABLE `absence` (
  `id` bigint NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `session_type_id` bigint NOT NULL,
  `subject_id` bigint NOT NULL,
  `subscription_id` bigint NOT NULL,
  `teacher_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `absence_justification`
--

CREATE TABLE `absence_justification` (
  `id` bigint NOT NULL,
  `justification` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `absence_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `account`
--

CREATE TABLE `account` (
  `id` bigint NOT NULL,
  `active` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `photo` bit(1) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `role_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `cne` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Gegevens worden geëxporteerd voor tabel `account`
--

INSERT INTO `account` (`id`, `active`, `email`, `password`, `photo`, `username`, `role_id`, `user_id`, `cne`) VALUES
(1, b'1', 'mohamed.enn2001@gmail.com', '$2a$12$1L.HAysGMzEzjuJwDRwieu2SEmOzwgK.tnp4BmFstHTaa6axFhYTO', b'0', 'mohamedenn', 2, 1, NULL);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `branch`
--

CREATE TABLE `branch` (
  `id` bigint NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `date_accreditation` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `teacher_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `branch_levels`
--

CREATE TABLE `branch_levels` (
  `branch_id` bigint NOT NULL,
  `levels_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `event_logging`
--

CREATE TABLE `event_logging` (
  `id` bigint NOT NULL,
  `date_time` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `event` varchar(255) DEFAULT NULL,
  `priority` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Gegevens worden geëxporteerd voor tabel `event_logging`
--

INSERT INTO `event_logging` (`id`, `date_time`, `description`, `event`, `priority`) VALUES
(5, '2023-06-06 04:15:47.103955', 'overview', 'admin', 1),
(6, '2023-06-06 04:17:14.929145', 'addStudentPage', 'admin', 1),
(7, '2023-06-06 04:18:37.746925', 'addStudent', 'admin', 1),
(8, '2023-06-06 04:19:30.660546', 'deleteStudent', 'admin', 1),
(9, '2023-06-06 12:07:45.156805', 'overview', 'admin', 1),
(10, '2023-06-06 12:23:10.226923', 'addStudent', 'admin', 1),
(11, '2023-06-06 12:24:16.550758', 'addStudent', 'admin', 1),
(12, '2023-06-06 12:25:04.552673', 'addStudent', 'admin', 1),
(13, '2023-06-06 12:25:26.349845', 'deleteStudent', 'admin', 1),
(14, '2023-06-06 12:25:40.631101', 'addStudent', 'admin', 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `level`
--

CREATE TABLE `level` (
  `id` bigint NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `branch_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `module`
--

CREATE TABLE `module` (
  `id` bigint NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `level_id` bigint DEFAULT NULL,
  `subject_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `role`
--

CREATE TABLE `role` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Gegevens worden geëxporteerd voor tabel `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_TEACHER'),
(2, 'ROLE_ADMIN'),
(3, 'ROLE_SUPER_ADMIN');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `session_type`
--

CREATE TABLE `session_type` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `students`
--

CREATE TABLE `students` (
  `id` int NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `firstName` varchar(100) NOT NULL,
  `city` varchar(100) NOT NULL,
  `tel` varchar(13) DEFAULT NULL,
  `email` varchar(320) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `branch` varchar(20) DEFAULT NULL,
  `dob` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Gegevens worden geëxporteerd voor tabel `students`
--

INSERT INTO `students` (`id`, `lastName`, `firstName`, `city`, `tel`, `email`, `gender`, `branch`, `dob`) VALUES
(1, 'ezfz', '\'\"ergre', 'FER', 'EFZ', 'EFGERG', 'Female', 'GI1', 'fezze'),
(2, 't\"\'t\"\'', 'greg', 'erg', 'reg', 'ergerg', 'Female', 'GI1', 'gerg');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `subject`
--

CREATE TABLE `subject` (
  `id` bigint NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `subscription`
--

CREATE TABLE `subscription` (
  `id` bigint NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `level_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `user`
--

CREATE TABLE `user` (
  `dtype` varchar(31) NOT NULL,
  `id` bigint NOT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `cne` varchar(255) DEFAULT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `specialty` varchar(255) DEFAULT NULL,
  `subscription_id` bigint DEFAULT NULL,
  `branch_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Gegevens worden geëxporteerd voor tabel `user`
--

INSERT INTO `user` (`dtype`, `id`, `fname`, `image`, `lname`, `phone`, `role`, `cne`, `dob`, `specialty`, `subscription_id`, `branch_id`) VALUES
('Admin', 1, 'Kum', 'http://lorempixel.com/g/1024/768/cats/', 'Hudson', '(450) 784-9430 x8391', NULL, NULL, NULL, NULL, NULL, NULL),
('Teacher', 3, 'Roseanna', 'http://lorempixel.com/g/1680/1050/nightlife/', 'Witting', '089.002.2036', NULL, NULL, NULL, NULL, NULL, NULL),
('Teacher', 5, 'Dominick', 'http://lorempixel.com/1366/768/fashion/', 'Hagenes', '268.050.4088 x1625', NULL, NULL, NULL, NULL, NULL, NULL),
('Student', 11, 'Mohamed', 'image.jpg', 'En-Nassibi', '0608970846', NULL, 'sz14397', '04-09-2001', NULL, NULL, NULL);

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `absence`
--
ALTER TABLE `absence`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKau2q3o1n43r1v3t0j9obxolur` (`session_type_id`),
  ADD KEY `FKfmjbcm5aajb7j0ems7cey8cl1` (`subject_id`),
  ADD KEY `FK90wmed65j8i4hr00t53kjrbt6` (`subscription_id`),
  ADD KEY `FKhrkq630a34i3ad4fv0y6i6aqc` (`teacher_id`);

--
-- Indexen voor tabel `absence_justification`
--
ALTER TABLE `absence_justification`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKigdfydp9g8v4q3n9peckqpd9l` (`absence_id`);

--
-- Indexen voor tabel `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_rtfnf9sje4nx22bioubj4yptg` (`cne`),
  ADD KEY `FKd4vb66o896tay3yy52oqxr9w0` (`role_id`),
  ADD KEY `FK7m8ru44m93ukyb61dfxw0apf6` (`user_id`);

--
-- Indexen voor tabel `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKq8jrfx06rwm7m9ic5d7e5dxu2` (`teacher_id`);

--
-- Indexen voor tabel `branch_levels`
--
ALTER TABLE `branch_levels`
  ADD UNIQUE KEY `UK_1b1n7pod58w3o5a7ag348wr1t` (`levels_id`),
  ADD KEY `FK9metn5sxy0qrjrfuk71876a5x` (`branch_id`);

--
-- Indexen voor tabel `event_logging`
--
ALTER TABLE `event_logging`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `level`
--
ALTER TABLE `level`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9qyrrpocnh41oo954exxinjf2` (`branch_id`);

--
-- Indexen voor tabel `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK35wv0wvx9m5ys40s3qukywmlo` (`level_id`),
  ADD KEY `FK64fjy7xrf5c5uct709tukfaqj` (`subject_id`);

--
-- Indexen voor tabel `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `session_type`
--
ALTER TABLE `session_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `students`
--
ALTER TABLE `students`
  ADD UNIQUE KEY `id` (`id`),
  ADD UNIQUE KEY `tel` (`tel`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexen voor tabel `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `subscription`
--
ALTER TABLE `subscription`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKs3syr2b63vrirbqi4p8dsbrk6` (`level_id`);

--
-- Indexen voor tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKb3msv39y7d4obq9nnmey7okq9` (`subscription_id`),
  ADD KEY `FK9yy0ya980j002yvtxi9r7kv6b` (`branch_id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `absence`
--
ALTER TABLE `absence`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `absence_justification`
--
ALTER TABLE `absence_justification`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `account`
--
ALTER TABLE `account`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT voor een tabel `branch`
--
ALTER TABLE `branch`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `event_logging`
--
ALTER TABLE `event_logging`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT voor een tabel `level`
--
ALTER TABLE `level`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `module`
--
ALTER TABLE `module`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT voor een tabel `session_type`
--
ALTER TABLE `session_type`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `students`
--
ALTER TABLE `students`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT voor een tabel `subject`
--
ALTER TABLE `subject`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `subscription`
--
ALTER TABLE `subscription`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Beperkingen voor geëxporteerde tabellen
--

--
-- Beperkingen voor tabel `absence`
--
ALTER TABLE `absence`
  ADD CONSTRAINT `FK90wmed65j8i4hr00t53kjrbt6` FOREIGN KEY (`subscription_id`) REFERENCES `subscription` (`id`),
  ADD CONSTRAINT `FKau2q3o1n43r1v3t0j9obxolur` FOREIGN KEY (`session_type_id`) REFERENCES `session_type` (`id`),
  ADD CONSTRAINT `FKfmjbcm5aajb7j0ems7cey8cl1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  ADD CONSTRAINT `FKhrkq630a34i3ad4fv0y6i6aqc` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`id`);

--
-- Beperkingen voor tabel `absence_justification`
--
ALTER TABLE `absence_justification`
  ADD CONSTRAINT `FKigdfydp9g8v4q3n9peckqpd9l` FOREIGN KEY (`absence_id`) REFERENCES `absence` (`id`);

--
-- Beperkingen voor tabel `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `FK7m8ru44m93ukyb61dfxw0apf6` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKd4vb66o896tay3yy52oqxr9w0` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

--
-- Beperkingen voor tabel `branch`
--
ALTER TABLE `branch`
  ADD CONSTRAINT `FKq8jrfx06rwm7m9ic5d7e5dxu2` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`id`);

--
-- Beperkingen voor tabel `branch_levels`
--
ALTER TABLE `branch_levels`
  ADD CONSTRAINT `FK9metn5sxy0qrjrfuk71876a5x` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`id`),
  ADD CONSTRAINT `FKby34b8d3yqvev2rvleouryhxx` FOREIGN KEY (`levels_id`) REFERENCES `level` (`id`);

--
-- Beperkingen voor tabel `level`
--
ALTER TABLE `level`
  ADD CONSTRAINT `FK9qyrrpocnh41oo954exxinjf2` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`id`);

--
-- Beperkingen voor tabel `module`
--
ALTER TABLE `module`
  ADD CONSTRAINT `FK35wv0wvx9m5ys40s3qukywmlo` FOREIGN KEY (`level_id`) REFERENCES `level` (`id`),
  ADD CONSTRAINT `FK64fjy7xrf5c5uct709tukfaqj` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`);

--
-- Beperkingen voor tabel `subscription`
--
ALTER TABLE `subscription`
  ADD CONSTRAINT `FKs3syr2b63vrirbqi4p8dsbrk6` FOREIGN KEY (`level_id`) REFERENCES `level` (`id`);

--
-- Beperkingen voor tabel `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK9yy0ya980j002yvtxi9r7kv6b` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`id`),
  ADD CONSTRAINT `FKb3msv39y7d4obq9nnmey7okq9` FOREIGN KEY (`subscription_id`) REFERENCES `subscription` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
