package com.gamingroom;

/**
 * Base class for shared entity information.
 */
public class Entity {
    private final long id;
    private final String name;

    /**
     * Constructor with an identifier and name.
     *
     * @param id unique identifier
     * @param name display name
     */
    protected Entity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
}
