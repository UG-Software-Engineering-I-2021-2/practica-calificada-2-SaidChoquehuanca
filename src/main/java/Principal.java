import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Principal {
    final private Map<Integer, List<Pair<Teacher, Boolean>>> allYearsTeachers = Map.ofEntries(
            new AbstractMap.SimpleImmutableEntry<>(
                    2020,
                    List.of(
                            new Pair<>( new Teacher(1,"Josefina"), true),
                            new Pair<>( new Teacher(1,"Edonisio"), true),
                            new Pair<>( new Teacher(1,"Edufasio"), false)
                    )
            ),
            new AbstractMap.SimpleImmutableEntry<>(
                    2019,
                    List.of(
                            new Pair<>( new Teacher(1,"Eduarda"), false),
                            new Pair<>( new Teacher(1,"Abelardo"), false),
                            new Pair<>( new Teacher(1,"Francisca"), false)
                    )
            )
    );
    private final int yearToCalculate;


    public Principal(int yearToCalculate) {
        this.yearToCalculate = yearToCalculate;
    }

    /*Profesores que otorgan puntos extra*/
    public String ImprimirProfesoresBuenos(){
        String texto = "Profesores que otorgan puntos extra:\n";
        for (Map.Entry<Integer, List<Pair<Teacher, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()){
            if (yearToCalculate == yearlyTeachers.getKey()){
                List<Pair<Teacher, Boolean>> teachers = yearlyTeachers.getValue();
                for (Pair<Teacher, Boolean> teacher : teachers) {
                    if (teacher.second()) {
                        texto += teacher.first().get_Nombre()+"\n";
                    }
                }
            }
        }
        return texto;
    }

    public boolean profesor_da_puntos(Teacher profesor){
        for (Map.Entry<Integer, List<Pair<Teacher, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()) {
            if (yearToCalculate == yearlyTeachers.getKey()) {
                List<Pair<Teacher, Boolean>> teachers = yearlyTeachers.getValue();
                for (Pair<Teacher, Boolean> teacher : teachers) {
                    if (teacher.second() && (Objects.equals(profesor.get_Nombre(), teacher.first().get_Nombre()))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String AlumnosConPuntosExtra(final List<Pair<Student,Teacher>> estudiantes_y_profesor , final boolean hasReachedMinimumClasses, final int minimo_asistencias){
        String texto = "Alumnos que obtuvieron puntos extra:\n";
        for (Pair<Student,Teacher> estudiante_profesor : estudiantes_y_profesor){
            if(hasReachedMinimumClasses && profesor_da_puntos(estudiante_profesor.second()) ){
                texto+=estudiante_profesor.first().get_Nombre()+"\n";
            }
            else {
                if (profesor_da_puntos(estudiante_profesor.second()) && minimo_asistencias<=estudiante_profesor.first().get_asistencias()){
                    texto+=estudiante_profesor.first().get_Nombre()+"\n";
                }
            }
        }

        return texto;


    }

    public float calculateGrades(final List<Pair<Integer, Float>> examsStudents, final boolean hasReachedMinimumClasses) {
        if (!examsStudents.isEmpty()) {
            boolean hasToIncreaseOneExtraPoint = false;
            /*
            for (Map.Entry<Integer, List<Pair<Teacher, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()) {
                if (!(yearToCalculate != yearlyTeachers.getKey())) {
                    List<Pair<Teacher, Boolean>> teachers = yearlyTeachers.getValue();
                    for (Pair<Teacher, Boolean> teacher : teachers) {
                        if (teacher.second() != true) {
                            continue;
                        }
                        hasToIncreaseOneExtraPoint = true;
                    }
                } else {
                    continue;
                }
            }
            */
            //Refactorizacion 1:
            for (Map.Entry<Integer, List<Pair<Teacher, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()) {
                if (yearToCalculate == yearlyTeachers.getKey()) {
                    List<Pair<Teacher, Boolean>> teachers = yearlyTeachers.getValue();
                    for (Pair<Teacher, Boolean> teacher : teachers) {
                        if (teacher.second()) {
                            hasToIncreaseOneExtraPoint = true;
                            break;
                        }
                    }
                }
            }
            //Fin de refactorizacion 1

            float gradesSum       = 0f;
            int   gradesWeightSum = 0;

            for (Pair<Integer, Float> examGrade : examsStudents) {
                gradesSum += (examGrade.first() * examGrade.second() / 100);
                gradesWeightSum += examGrade.first();
            }
            if (gradesWeightSum == 100) {
                if (hasReachedMinimumClasses) {
                    if (hasToIncreaseOneExtraPoint) {
                        return Float.min(10f, gradesSum + 1);
                    } else {
                        return gradesSum;
                    }
                } else {
                    return 0f;
                }
            } else if (gradesWeightSum > 100) {
                return -1f;
            } else {
                return -2f;
            }
        } else {
            return 0f;
        }
    }


    public static void main(String[] args) {
     System.out.println("Hola");
    }
}
