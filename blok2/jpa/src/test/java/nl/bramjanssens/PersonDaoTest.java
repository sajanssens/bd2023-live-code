package nl.bramjanssens;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonDaoTest {

    @Mock
    private EntityManager emMock;

    @Mock
    private EntityTransaction tMock;

    @InjectMocks
    private PersonDao target;

    @Test
    void whenInsertWithValidPersonThenTransactionIsCommitted() {
        // given
        when(emMock.getTransaction()).thenReturn(tMock);
        doNothing().when(emMock).persist(any(Person.class));

        // when
        target.insert(new Person());

        // then
        verify(emMock).persist(any(Person.class));
        verify(tMock).begin();
        verify(tMock).commit();
    }

    @Test
    void whenInsertAndSQLExceptionThenTransactionIsRolledBack() {
        // given
        when(emMock.getTransaction()).thenReturn(tMock);
        doThrow(EntityExistsException.class).when(emMock).persist(any(Person.class));

        // when
        target.insert(new Person());

        // then
        verify(emMock).persist(any(Person.class));
        verify(tMock).begin();
        verify(tMock, never()).commit();
        verify(tMock).rollback();
    }
}
