drop table if exists material_resource;
drop table if exists supplier_material_resource;
drop table if exists supplier;
drop table if exists structure_company;
drop table if exists structure_company_material_resource;

create table material_resource
(
    id                          int NOT NULL AUTO_INCREMENT,
    ins_time                    timestamp,
    "name"                      varchar(255),
    upd_time                    timestamp,
    code                        varchar(20),
    short_name                  varchar(50),
    full_name                   varchar(255),
    is_generic                  boolean,
    short_name_for_shift_report varchar(50),
    source_transport_code       varchar(50),
    source_axapta_code          varchar(50),
    source_up_agp_code          varchar(50),
    source_lab_code             varchar(50),
    source_lifnr_code           varchar(50),
    inside_lode_code            varchar(50),
    PRIMARY KEY (ID)
);

create table supplier
(
    id                    int NOT NULL AUTO_INCREMENT,
    ins_time              timestamp,
    "name"                varchar(255),
    upd_time              timestamp,
    code                  varchar(50),
    source_transport_code varchar(50),
    source_axapta_code    varchar(50),
    source_up_agp_code    varchar(50),
    source_lab_code       varchar(50),
    structure_company_id  int,
    short_name            varchar(50),
    source_lifnr_code     varchar(50),
    inside_lode_code      varchar(50),
    PRIMARY KEY (ID)
);

create table supplier_material_resource
(
    id                   int NOT NULL AUTO_INCREMENT,
    material_resource_id int,
    supplier_id          int,
    ins_time             timestamp,
    upd_time             timestamp,
    PRIMARY KEY (ID)
);

create table structure_company
(
    id                    int NOT NULL,
    ins_time              timestamp,
    "name"                varchar(255),
    upd_time              timestamp,
    code                  varchar(50),
    parent_id             int,
    short_name            varchar(50),
    source_transport_code varchar(50),
    lab_code              varchar(50),
    source_axapta_code    varchar(50),
    source_up_agp_code    varchar(50),
    source_lab_code       varchar(50),
    structure_type        varchar(50),
    source_lifnr_code     varchar(50),
    inside_lode_code      varchar(50),
    PRIMARY KEY (ID)
);

create table structure_company_material_resource
(
    id int NOT NULL AUTO_INCREMENT,
    ins_time timestamp,
    upd_time timestamp,
    material_resource_id int,
    structure_company_id int,
    PRIMARY KEY (ID)
);





