select count(1) from cita where fecha_entrada = :fecha_entrada and :hora_entrada BETWEEN hora_entrada AND hora_salida