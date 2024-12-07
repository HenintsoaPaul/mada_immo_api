-- insert
CREATE OR REPLACE FUNCTION insert_location_fille()
    RETURNS TRIGGER AS
$$
BEGIN
    INSERT INTO location_fille (date_location,
                                id_location_mere)
    SELECT NEW.date_debut + generate_series(0, NEW.duree - 1) * INTERVAL '1 month',
           NEW.id_location;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE TRIGGER trg_insert_location_fille
    AFTER INSERT
    ON location
    FOR EACH ROW
EXECUTE FUNCTION insert_location_fille();