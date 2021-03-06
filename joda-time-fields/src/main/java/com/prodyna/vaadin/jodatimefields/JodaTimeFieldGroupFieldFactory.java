package com.prodyna.vaadin.jodatimefields;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.LocalTime;

import com.vaadin.data.fieldgroup.DefaultFieldGroupFieldFactory;
import com.vaadin.ui.Field;

public class JodaTimeFieldGroupFieldFactory extends DefaultFieldGroupFieldFactory {
    @Override
    public <T extends Field> T createField(Class<?> type, Class<T> fieldType) {
        if (type == DateTime.class) {
            return (T) new DateTimeField();
        } else if (type == LocalTime.class) {
            return (T) new LocalTimeField();
        } else if (type == Interval.class) {
            return (T) new IntervalField();
        }
        return super.createField(type, fieldType);
    }
}
