package nl.belastingdienst.rest.util.interceptor;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.NANOS;

// Also declared in beans.xml
@MeasureMethodDuration
@Interceptor // AOP = Aspect Oriented Programming
public class MethodDurationInterceptor {

    @AroundInvoke
    public Object check(InvocationContext ic) throws Exception {
        var startTime = LocalDateTime.now();
        try {
            return ic.proceed(); // like chain.next
        } finally {
            var endTime = LocalDateTime.now();
            long duration = NANOS.between(startTime, endTime);
            System.out.println(ic.getClass().getSimpleName() + " " + ic.getMethod().getName() + " method duration was " + duration);
        }
    }
}
