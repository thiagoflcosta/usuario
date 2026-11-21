package com.thiago.usuario.business.converter;

import com.thiago.usuario.business.dto.EnderecoDTO;
import com.thiago.usuario.business.dto.TelefoneDTO;
import com.thiago.usuario.business.dto.UsuarioDTO;
import com.thiago.usuario.infraestructure.entidy.Endereco;
import com.thiago.usuario.infraestructure.entidy.Telefone;
import com.thiago.usuario.infraestructure.entidy.Usuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioConverter {

    public Usuario paraUsuario (UsuarioDTO usuarioDTO){
        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEndereco(usuarioDTO.getEnderecos()))
                .telefones(paraListaTelefone(usuarioDTO.getTelefones()))
                .build();
    }
    //PAREI AQUI
    public List<Endereco> paraListaEndereco(List<EnderecoDTO> enderecoDTOS){
        //Forma 1
        return enderecoDTOS.stream().map(this::paraEndereco).toList();
        //Forma 2
        /*
        List<Endereco> enderecos = new ArrayList<>();
        for(EnderecoDTO enderecoDTO: enderecoDTOS){
            enderecos.add(paraEndereco(enderecoDTO));
        }
        return enderecos;*/
    }

    public Endereco paraEndereco (EnderecoDTO enderecoDTO){
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .cep(enderecoDTO.getCep())
                .cidade(enderecoDTO.getCidade())
                .complemento(enderecoDTO.getComplemento())
                .estado(enderecoDTO.getEstado())
                .build();
    }
   public List<Telefone> paraListaTelefone(List<TelefoneDTO> telefoneDTOS){
        return telefoneDTOS.stream().map(this::paraTelefone).toList();
   }

   public Telefone paraTelefone(TelefoneDTO telefoneDTO){
        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
   }

    public UsuarioDTO paraUsuarioDTO (Usuario usuario){
        return UsuarioDTO.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .enderecos(paraListaEnderecoDTO(usuario.getEnderecos()))
                .telefones(paraListaTelefoneDTO(usuario.getTelefones()))
                .build();
    }

    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> endereco){
        //Forma 1
        return endereco.stream().map(this::paraEnderecoDTO).toList();
        //Forma 2
        /*
        List<Endereco> enderecos = new ArrayList<>();
        for(EnderecoDTO enderecoDTO: enderecoDTOS){
            enderecos.add(paraEndereco(enderecoDTO));
        }
        return enderecos;*/
    }

    public EnderecoDTO paraEnderecoDTO (Endereco endereco){
        return EnderecoDTO.builder()
                .rua(endereco.getRua())
                .numero(endereco.getNumero())
                .cep(endereco.getCep())
                .cidade(endereco.getCidade())
                .complemento(endereco.getComplemento())
                .estado(endereco.getEstado())
                .build();
    }
    public List<TelefoneDTO> paraListaTelefoneDTO(List<Telefone> telefone){
        return telefone.stream().map(this::paraTelefoneDTO).toList();
    }

    public TelefoneDTO paraTelefoneDTO(Telefone telefone){
        return TelefoneDTO.builder()
                .numero(telefone.getNumero())
                .ddd(telefone.getDdd())
                .build();
    }

}
