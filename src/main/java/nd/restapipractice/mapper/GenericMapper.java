package nd.restapipractice.mapper;


public interface GenericMapper<E,T,U> {
    E toEntity(T t);
    U toResponse(E e);
}