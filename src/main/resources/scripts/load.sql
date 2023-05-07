CREATE TABLE public.customer (
                               id uuid NOT NULL,,
                               name character varying(255) NOT NULL,
                               email character varying(255) NOT NULL,
                               phone character varying(255) NOT NULL,
                               country character varying(255) NOT NULL,
                               created_at TIMESTAMP NOT NULL DEFAULT now(),
                               updated_at TIMESTAMP NOT NULL DEFAULT now()
);


ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (id);

--
-- insert data

INSERT INTO customer VALUES ('6d0114ef-a0bf-45ce-9576-aaeba6b246e4','John Doe', 'johndoe@example.com', '+1-555-1234', 'France');
INSERT INTO customer VALUES ('0e81c2e5-fbfb-4f58-916c-5728f5cbc017','Jane Smith', 'janesmith@example.com', '+1-555-5678','Belgium');
INSERT INTO customer VALUES ('f0978426-5130-4f27-927c-3bd4c91f3e32','Bob Johnson', 'bobjohnson@example.com', '+1-555-9012', 'Spain');