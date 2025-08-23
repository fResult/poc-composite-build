CREATE TABLE IF NOT EXISTS customers (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  full_name VARCHAR(255) NOT NULL
);

INSERT INTO customers (full_name) VALUES ('John Wick');
INSERT INTO customers (full_name) VALUES ('Thomas A. Anderson');
