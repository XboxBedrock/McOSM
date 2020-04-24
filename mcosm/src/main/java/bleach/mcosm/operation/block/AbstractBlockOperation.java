package bleach.mcosm.operation.block;

import bleach.mcosm.operation.Operation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class AbstractBlockOperation extends Operation {
	
	protected void setBlock(BlockPos pos, World world, IBlockState state) {
		world.getChunk(pos.getX() >> 4, pos.getZ() >> 4).setBlockState(pos, state);
		world.getChunk(pos.getX() >> 4, pos.getZ() >> 4).onTick(false);
	}
	
	protected void validateBlock(BlockPos pos, World world, World clWorld) {
		world.markAndNotifyBlock(pos, world.getChunk(pos.getX() >> 4, pos.getZ() >> 4), clWorld.getBlockState(pos), world.getBlockState(pos), 2);
	}
	
	protected boolean useMainThread() {
		return true;
	}
}
