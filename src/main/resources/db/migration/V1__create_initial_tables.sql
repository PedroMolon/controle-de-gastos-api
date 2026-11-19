CREATE TABLE tb_users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    balance NUMERIC(10, 2) NOT NULL DEFAULT 0.00,
    createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tb_categories (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(20) NOT NULL CHECK (type in ('INCOME', 'EXPENSE')),
    user_id BIGINT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES tb_users(id) ON DELETE CASCADE
);

CREATE TABLE tb_transactions (
    id BIGSERIAL PRIMARY KEY,
    description TEXT,
    amount NUMERIC(10, 2) NOT NULL CHECK (amount > 0),
    type VARCHAR(20) NOT NULL CHECK (type in ('INCOME', 'EXPENSE')),
    date DATE NOT NULL DEFAULT CURRENT_DATE,
    category_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES tb_categories(id) ON DELETE CASCADE,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES tb_users(id) ON DELETE CASCADE
);

CREATE INDEX idx_transaction_user_date ON tb_transactions(user_id, date);
CREATE INDEX idx_transaction_category ON tb_transactions(category_id);