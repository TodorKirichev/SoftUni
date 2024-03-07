package p06_TirePressureMonitoringSystem;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AlarmTest {

    @Test
    public void checkAlarmTurnOnUnderPressureThreshold() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(15.0);
        Alarm alarm = new Alarm(sensor);
        alarm.check();

        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void checkAlarmTurnOnOverPressureThreshold() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(25.0);
        Alarm alarm = new Alarm(sensor);
        alarm.check();

        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void checkAlarmWithNormalPressure() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(20.0);
        Alarm alarm = new Alarm(sensor);
        alarm.check();

        assertFalse(alarm.getAlarmOn());
    }

}