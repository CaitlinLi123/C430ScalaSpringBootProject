-- =====================
-- Insert Categories
-- =====================
INSERT INTO CATEGORY (NAME) VALUES ('Work');
INSERT INTO CATEGORY (NAME) VALUES ('Personal');
INSERT INTO CATEGORY (NAME) VALUES ('Hobby');
INSERT INTO CATEGORY (NAME) VALUES ('Health');
INSERT INTO CATEGORY (NAME) VALUES ('Learning');

-- =====================
-- Insert Tasks
-- =====================
-- Work tasks (category_id = 1)
INSERT INTO TASK (TITLE, DESCRIPTION, DUE_DATE, COMPLETED, PRIORITY, CATEGORY_ID)
VALUES ('Finish report', 'Complete the Q4 financial report', '2025-11-20', FALSE, 'HIGH', 1);

INSERT INTO TASK (TITLE, DESCRIPTION, DUE_DATE, COMPLETED, PRIORITY, CATEGORY_ID)
VALUES ('Team meeting', 'Discuss project milestones', '2025-11-18', FALSE, 'MEDIUM', 1);

-- Personal tasks (category_id = 2)
INSERT INTO TASK (TITLE, DESCRIPTION, DUE_DATE, COMPLETED, PRIORITY, CATEGORY_ID)
VALUES ('Buy groceries', 'Milk, Eggs, Bread', '2025-11-15', FALSE, 'LOW', 2);

INSERT INTO TASK (TITLE, DESCRIPTION, DUE_DATE, COMPLETED, PRIORITY, CATEGORY_ID)
VALUES ('Call mom', 'Weekly check-in call', '2025-11-16', FALSE, 'MEDIUM', 2);

-- Hobby tasks (category_id = 3)
INSERT INTO TASK (TITLE, DESCRIPTION, DUE_DATE, COMPLETED, PRIORITY, CATEGORY_ID)
VALUES ('Practice guitar', '30 minutes of scales', '2025-11-14', FALSE, 'MEDIUM', 3);

INSERT INTO TASK (TITLE, DESCRIPTION, DUE_DATE, COMPLETED, PRIORITY, CATEGORY_ID)
VALUES ('Read a novel', 'Finish reading "The Hobbit"', '2025-11-20', FALSE, 'LOW', 3);

-- Health tasks (category_id = 4)
INSERT INTO TASK (TITLE, DESCRIPTION, DUE_DATE, COMPLETED, PRIORITY, CATEGORY_ID)
VALUES ('Gym session', 'Leg day workout', '2025-11-15', FALSE, 'HIGH', 4);

INSERT INTO TASK (TITLE, DESCRIPTION, DUE_DATE, COMPLETED, PRIORITY, CATEGORY_ID)
VALUES ('Meditation', '15 minutes in the morning', '2025-11-14', TRUE, 'MEDIUM', 4);

-- Learning tasks (category_id = 5)
INSERT INTO TASK (TITLE, DESCRIPTION, DUE_DATE, COMPLETED, PRIORITY, CATEGORY_ID)
VALUES ('Scala tutorial', 'Complete chapter on Futures', '2025-11-19', FALSE, 'HIGH', 5);

INSERT INTO TASK (TITLE, DESCRIPTION, DUE_DATE, COMPLETED, PRIORITY, CATEGORY_ID)
VALUES ('Spring Boot lab', 'Implement H2 database integration', '2025-11-18', FALSE, 'HIGH', 5);
