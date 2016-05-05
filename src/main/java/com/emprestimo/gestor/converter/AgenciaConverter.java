package com.emprestimo.gestor.converter;

import com.emprestimo.gestor.model.Agencia;
import com.emprestimo.gestor.repository.AgenciaFacade;
import java.util.Map;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.primefaces.convert.ClientConverter;
import org.apache.commons.lang3.StringUtils;


@FacesConverter(forClass = Agencia.class, value = "agenciaConverter")
public class AgenciaConverter implements Converter, ClientConverter {

    @Inject
    private AgenciaFacade ejbFacade;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        Agencia retorno = null;
        
        if(StringUtils.isNotEmpty(value)){
            retorno = ejbFacade.porId(Integer.parseInt(value));
        }
     
        return retorno;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
       if(object != null){
           return ((Agencia) object).getCodAgencia().toString();
       }
       return "";
    }

    @Override
    public Map<String, Object> getMetadata(){
        return null;
    }

    @Override
    public String getConverterId() {
        return "com.emprestimo.Agencia";
    }
}
