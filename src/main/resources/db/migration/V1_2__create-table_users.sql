--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: yxfan
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE users_id_seq OWNER TO yxfan;

--
-- Name: users; Type: TABLE; Schema: public; Owner: yxfan; Tablespace: 
--

CREATE TABLE users (
    id bigint DEFAULT nextval('users_id_seq'::regclass) NOT NULL,
    bio character varying(255),
    gender character varying(255),
    name character varying(255)
);

ALTER TABLE users OWNER TO yxfan;
