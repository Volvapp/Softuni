package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest  {

    @Test
    public void testAlarmWithLowerValue(){
        Sensor sensor = Mockito.mock(Sensor.class);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(15.3);
        //TODO Mocking

        Alarm alarm = new Alarm(sensor);

        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }
    @Test
    public void testAlarmWithHigherValue(){
        Sensor sensor = Mockito.mock(Sensor.class);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(23.5);

        Alarm alarm = new Alarm(sensor);

        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }
    @Test
    public void testAlarmWithNormalValue(){

        Sensor sensor = Mockito.mock(Sensor.class);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(18.3);

        Alarm alarm = new Alarm(sensor);

        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }
}