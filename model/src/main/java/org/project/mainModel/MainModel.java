package org.project.mainModel;

import org.project.DAO.entityDAO.DisplayDataDAOImplement;
import org.project.DAO.entityDAO.ScepticDataDAOImplementation;
import org.project.Model;
import org.project.entity.DisplayData;
import org.project.entity.ScepticData;

import java.sql.SQLException;
import java.util.List;

public class MainModel extends Model {
    private final DisplayDataDAOImplement displayDataDAOImplement;
    private final ScepticDataDAOImplementation scepticDataDAOImplementation;


    public MainModel() {
        displayDataDAOImplement = new DisplayDataDAOImplement();
        scepticDataDAOImplementation = new ScepticDataDAOImplementation();
    }

    public List<DisplayData> getDisplayData() throws SQLException {
        return displayDataDAOImplement.getAll();
    }

    public List<ScepticData> getScepticData() throws SQLException {
        return scepticDataDAOImplementation.getAll();
    }


}
