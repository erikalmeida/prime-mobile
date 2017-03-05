package com.si.servialdana.prime.sql.conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.si.servialdana.prime.sql.modelo.Grupo;
import com.si.servialdana.prime.sql.modelo.Usuario;
import com.si.servialdana.prime.sql.modelo.Sistema;
import com.si.servialdana.prime.sql.modelo.promocion;
import com.si.servialdana.prime.sql.modelo.servicio;

import java.sql.SQLException;


public class DBHelper extends OrmLiteSqliteOpenHelper {

    private static final String NOMBRE_BASE_DE_DATOS= "prime.sqlite";
    private static final Integer VERSION_BASE_DE_DATOS= 1;
    private static DBHelper dbHelper;

    //Aqui van los atributos relacionados a las tablas de base de datos que se desean gestionar
    private RuntimeExceptionDao<Grupo,Integer> rolIntegerDao;
    private RuntimeExceptionDao<Usuario, Integer> usuarioIntegerDao;
    private RuntimeExceptionDao<Sistema, String> sistemaStringDao = null;
    private RuntimeExceptionDao<promocion, Integer> promocionIntegerDao = null;
    private RuntimeExceptionDao<servicio, Integer> servicioIntegerDao=null;


    public DBHelper(Context context) {
         super(context, NOMBRE_BASE_DE_DATOS, null, VERSION_BASE_DE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource , Usuario.class);
            TableUtils.createTable(connectionSource, Grupo.class);
            TableUtils.createTable(connectionSource, Sistema.class);
            TableUtils.createTable(connectionSource, promocion.class);
            TableUtils.createTable(connectionSource, servicio.class);
        } catch (SQLException e) {
            throw new RuntimeException("Ha ocurrido un error en la creacion de la base de datos");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        onCreate(database,connectionSource);
    }

    public RuntimeExceptionDao<Grupo, Integer> getRuntimeExceptionRolDao() throws SQLException{
        if(rolIntegerDao==null){
            rolIntegerDao= getDao(Grupo.class);
        }
        return rolIntegerDao;
    }

    public RuntimeExceptionDao<Usuario, Integer> getRuntimeExceptionUsuarioDao() throws SQLException{
        if(usuarioIntegerDao==null){
            usuarioIntegerDao= getDao(Usuario.class);
        }
        return usuarioIntegerDao;
    }


    public RuntimeExceptionDao<Sistema, String> getRuntimeExceptionSistemaDao(){
        if(sistemaStringDao==null){
            sistemaStringDao = getRuntimeExceptionDao(Sistema.class);
        }
        return sistemaStringDao;
    }

    public RuntimeExceptionDao<promocion, Integer> getRuntimeExceptionPromocionDao(){
        if(promocionIntegerDao==null){
         promocionIntegerDao = getRuntimeExceptionDao(promocion.class);
        }
        return this.promocionIntegerDao;
    }

    public RuntimeExceptionDao<servicio, Integer> getRuntimeExceptionServicioDao(){
        if(servicioIntegerDao==null){
            servicioIntegerDao = getRuntimeExceptionDao(servicio.class);
        }
        return this.servicioIntegerDao;
    }

    public DBHelper getHelper(Context context){
        if(dbHelper==null){
            dbHelper= OpenHelperManager.getHelper(context, DBHelper.class);
        }
        return dbHelper;
    }

    public void closeHelper(){
        if (dbHelper!=null){
            OpenHelperManager.releaseHelper();
            dbHelper=null;
        }
    }

    @Override
    public void close(){
        super.close();
    }
}
