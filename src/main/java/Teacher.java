public class Teacher {
    private String _Nombre;
    private int _Tipo;
    private int _salarioBaseMensual =2000;
    private int _comision = 500;
    private int _bonus = 100;
    static final int ProfesorTP = 0;
    static final int ProfesorTC = 1;
    static final int Administrativo = 2;
    Teacher(int type, String nombre) {
        _Tipo = type;
        _Nombre = nombre;
    }
    int Sueldo() {
        switch (_Tipo) {
            case ProfesorTP:
                return _salarioBaseMensual;
            case ProfesorTC:
                return _salarioBaseMensual + _comision;
            case Administrativo:
                return _salarioBaseMensual + _bonus;
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

    public int get_salarioBaseMensual() {
        return _salarioBaseMensual;
    }

    public void set_salarioBaseMensual(int _salarioBaseMensual) {
        this._salarioBaseMensual = _salarioBaseMensual;
    }

    public int get_comision() {
        return _comision;
    }

    public void set_comision(int _comision) {
        this._comision = _comision;
    }

    public int get_bonus() {
        return _bonus;
    }

    public void set_bonus(int _bonus) {
        this._bonus = _bonus;
    }
}
