public class Student {
    private String _Nombre;
    private int _Tipo;
    private int _notaBase =11;
    private int _asistencias = 0;
    static final int Pregado = 0;
    static final int Maestria = 1;
    static final int Doctorado = 2;

    Student(int type, String nombre,int asistencias) {
        _Tipo = type;
        _Nombre = nombre;
        _asistencias = asistencias;
    }
    int Grado() {
        switch (_Tipo) {
            case Pregado:
                return _notaBase;
            case Maestria:
                return _notaBase + 1;
            case Doctorado:
                return _notaBase + 2;
            default:
                throw new RuntimeException("Empleado incorrecto");
        }
    }

    public String get_Nombre() {
        return _Nombre;
    }

    public void set_Nombre(String _Nombre) {
        this._Nombre = _Nombre;
    }

    public int get_Tipo() {
        return _Tipo;
    }

    public void set_Tipo(int _Tipo) {
        this._Tipo = _Tipo;
    }

    public int get_notaBase() {
        return _notaBase;
    }

    public int get_asistencias() {
        return _asistencias;
    }

    public void set_asistencias(int _asistencias) {
        this._asistencias = _asistencias;
    }

    public void set_notaBase(int _notaBase) {
        this._notaBase = _notaBase;
    }
}
