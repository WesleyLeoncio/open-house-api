package wl.open_house_api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wl.open_house_api.infra.exeptions.ValidacaoException;
import wl.open_house_api.model.role.entity.Role;
import wl.open_house_api.model.role.mapper.RoleMapper;
import wl.open_house_api.model.role.request.RoleRequest;
import wl.open_house_api.model.role.request.RoleRequestCreat;
import wl.open_house_api.model.role.response.RoleResponse;
import wl.open_house_api.repository.RoleRepository;
import java.util.Optional;

@Service
public class RoleService {

    final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }


    @Transactional
    public RoleResponse insert(RoleRequestCreat roleRequestCreat) {
        Role role = repository.save(RoleMapper.INSTANCE.roleRequestCreatToRole(roleRequestCreat));
        return RoleMapper.INSTANCE.roleToRoleResponse(role);
    }

    @Transactional
    public RoleResponse update(RoleRequest roleRequest) {
        verificiarRole(roleRequest.id());
        Role role = repository.save(RoleMapper.INSTANCE.roleRequestToRole(roleRequest));
        return RoleMapper.INSTANCE.roleToRoleResponse(role);
    }


    @Transactional
    public RoleResponse findRole(Long id) {
        Role role = repository.getReferenceById(id);
        return RoleMapper.INSTANCE.roleToRoleResponse(role);
    }


    public Page<RoleResponse> findRoles(Pageable pageable) {
        return repository.findAll(pageable).map(RoleMapper.INSTANCE::roleToRoleResponse);
    }


    @Transactional
    public void deleteRole(Long id) {
        repository.delete(verificiarRole(id));
    }


    public Role verificiarRole(Long id){
        Optional<Role> role = repository.findById(id);
        if(role.isEmpty()){
            throw new ValidacaoException("Profile não existe, verifique e tente e novamente!");
        }
        return role.get();
    }
}
