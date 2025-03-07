import type { ComponentInternalInstance, VNode } from 'vue';
import type { TabsPanes } from '../tabs';
export declare const getTabPanes: (vm: ComponentInternalInstance) => VNode<import("vue").RendererNode, import("vue").RendererElement, {
    [key: string]: any;
}>[];
export declare const getOrderedPanes: (vm: ComponentInternalInstance, panes: TabsPanes) => {
    uid: number;
    slots: Readonly<{
        [name: string]: import("vue").Slot | undefined;
    }>;
    props: {
        readonly disabled: boolean;
        readonly label: string;
        readonly closable: boolean;
        readonly lazy: boolean;
        readonly name?: import("element-plus/es/utils").EpPropMergeType<readonly [StringConstructor, NumberConstructor], unknown, unknown> | undefined;
    };
    paneName: string | number | undefined;
    active: boolean;
    index: string | undefined;
    isClosable: boolean;
}[];
