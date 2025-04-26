LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'Angelus','Munity',NULL,'São Paulo - SP','Male');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;