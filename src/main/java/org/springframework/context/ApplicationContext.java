package org.springframework.context;

import org.springframework.beans.factory.xml.HierarchicalBeanFactory;
import org.springframework.beans.factory.xml.ListableBeanFactory;
import org.springframework.core.io.ResourceLoader;

/**
 * 应用上下文
 *
 * @author cuzz
 * @date 2022/2/16 22:40
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
