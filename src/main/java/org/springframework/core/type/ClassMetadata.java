package org.springframework.core.type;

/**
 * Interface that defines abstract metadata of a specific class,
 * in a form that does not require that class to be loaded yet.
 *
 *
 * @author cuzz
 * @date 2022/3/4 00:44
 */
public interface ClassMetadata {

    /**
     * Return the name of the underlying class.
     */
    String getClassName();

    /**
     * Return whether the underlying class represents an interface.
     */
    boolean isInterface();

    /**
     * Return whether the underlying class represents an annotation.
     *
     * @since 4.1
     */
    boolean isAnnotation();

}
