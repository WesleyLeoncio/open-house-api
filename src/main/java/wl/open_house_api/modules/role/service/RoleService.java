package wl.open_house_api.modules.role.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wl.open_house_api.infra.exeptions.ObjectNotFoundExeption;
import wl.open_house_api.modules.role.model.entity.Role;
import wl.open_house_api.modules.role.model.enuns.Roles;
import wl.open_house_api.modules.role.model.mapper.RoleMapper;
import wl.open_house_api.modules.role.model.request.RoleRequest;
import wl.open_house_api.modules.role.model.response.RoleResponse;
import wl.open_house_api.modules.role.repository.RoleRepository;

import java.util.UUID;


@Service
public class RoleService implements IRoleService {

    final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public RoleResponse insert(RoleRequest roleRequest) {
        Role role = repository.save(RoleMapper.INSTANCE.roleRequestToRole(roleRequest));
        return RoleMapper.INSTANCE.roleToRoleResponse(role);
    }

    @Override
    @Transactional
    public RoleResponse update(UUID id, RoleRequest roleRequest) {
        verificarRole(id);
        Role role = RoleMapper.INSTANCE.roleRequestToRole(roleRequest);
        role.setId(id);
        return RoleMapper.INSTANCE.roleToRoleResponse(repository.save(role));
    }

    @Override
    @Transactional
    public RoleResponse findRole(UUID id) {
        return RoleMapper.INSTANCE.roleToRoleResponse(verificarRole(id));
    }

    @Override
    public Page<RoleResponse> findRoles(Pageable pageable) {
        return repository.findAll(pageable).map(RoleMapper.INSTANCE::roleToRoleResponse);
    }

    @Override
    @Transactional
    public void deleteRole(UUID id) {
        repository.delete(verificarRole(id));
    }


    public Role verificarRole(UUID id){
        return repository.findById(id).orElseThrow(ObjectNotFoundExeption::new);
    }

    public Role buscarRoleUser(){
        return repository.findByNome(Roles.ROLE_USER);
    }


}
