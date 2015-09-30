--
-- Name: todoitems_id_seq; Type: SEQUENCE; Schema: public; Owner: yxfan
--

CREATE SEQUENCE todoitems_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE todoitems_id_seq OWNER TO yxfan;

--
-- Name: todoitems; Type: TABLE; Schema: public; Owner: yxfan; Tablespace: 
--

CREATE TABLE todoitems (
    id bigint DEFAULT nextval('todoitems_id_seq'::regclass) NOT NULL,
    content character varying(255),
    name character varying(255),
    userid bigint NOT NULL
);

ALTER TABLE todoitems OWNER TO yxfan;
