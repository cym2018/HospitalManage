package org.example.bed;

import org.example.recode.Recode;
import org.example.section.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 病床管理相关业务逻辑
 */
@Service
public class BedService {

    @Autowired
    private BedRepository bedRepository;
    @Autowired
    private SectionService sectionService;

    /**
     * @param bed 实体
     * @return 更新后的实体
     * @description 保存实体
     */
    public Bed save(Bed bed) {
        return bedRepository.save(bed);
    }

    /**
     * @param No 床号
     * @return 寻找到的记录
     * @description 根据床号查找记录
     */
    public Bed findByNo(String No) {
        return bedRepository.findByNo(No);
    }

    /**
     * @return 所有列表视图
     * @description 查询全部记录, 并转换为列表视图
     */
    public List<BedListView> findAllListView() {
        List<BedListView> bedList = new ArrayList<>();
        bedRepository.findAll().forEach(o -> bedList.add(new BedListView(o)));
        return bedList;
    }

    /**
     * @param bed    病床实体
     * @param recode 记录实体
     * @return 更新后的病床实体
     * @description 为病床添加一条关联的记录
     */
    public Bed addRecode(Bed bed, Recode recode) {
        bed.addRecode(recode);
        return save(bed);
    }

    public Bed getOrCreate(Integer id) {
        if (id == null) {
            return new Bed();
        } else {
            return bedRepository.findById(id).orElse(new Bed());
        }
    }

    public void setSection(Bed bed, Integer sectionId) {
        bed.setSection(sectionService.findById(sectionId));
    }

    public void remove(Bed bed) {
        bedRepository.delete(bed);
    }
}
