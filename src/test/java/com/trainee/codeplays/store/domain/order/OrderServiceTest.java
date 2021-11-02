package com.trainee.codeplays.store.domain.order;

import com.trainee.codeplays.store.domain.payment.PaymentService;
import com.trainee.codeplays.store.domain.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    PaymentService paymentService;
    @Mock
    UserService userService;
    @InjectMocks
    OrderService orderService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Deve lançar uma exceção quando o usuário for menor de idade")
    public void ShouldThrowsAnExceptionWhenUserIsMinor(){

        when(userService.isUserMinor(eq(1L))).thenReturn(true);
        doNothing().when(paymentService).pay();

        Order order = new Order(1L);

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> orderService.create(order));

        assertEquals("O usuário não pode ser menor de idade", exception.getMessage());

        verify(userService, times(1)).isUserMinor(eq(1L));
        verify(paymentService, times(0)).pay();
    }

    @Test
    @DisplayName("Deve liberar para o pagamento quando o usuário for maior de idade")
    public void ShouldPayWhenUserMajor(){
        Order order = new Order(2L);

        when(userService.isUserMinor(eq(2L))).thenReturn(false);
        doNothing().when(paymentService).pay();

        orderService.create(order);

        verify(userService, times(1)).isUserMinor(eq(2L));
        verify(paymentService, times(1)).pay();
    }
}
